package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.JobSeedRootDto;
import softuni.exam.models.entity.Company;
import softuni.exam.models.entity.Job;
import softuni.exam.repository.JobRepository;
import softuni.exam.service.CompanyService;
import softuni.exam.service.JobService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class JobServiceImpl implements JobService {
    private static final String JOBS_SEED_XML_FILE = "src/main/resources/files/xml/jobs.xml";
    private final JobRepository jobRepository;
    private final CompanyService companyService;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public JobServiceImpl(JobRepository jobRepository, CompanyService companyService,
                          XmlParser xmlParser, ValidationUtil validationUtil,
                          ModelMapper modelMapper) {
        this.jobRepository = jobRepository;
        this.companyService = companyService;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return jobRepository.count() > 0;
    }

    @Override
    public String readJobsFileContent() throws IOException {
        return Files.readString(Path.of(JOBS_SEED_XML_FILE));
    }

    @Override
    public String importJobs() throws IOException, JAXBException {
        if (!areImported()) {
            StringBuilder strBuilder = new StringBuilder();

            xmlParser
                    .fromFile(JOBS_SEED_XML_FILE, JobSeedRootDto.class)
                    .getJobSeedDtoList()
                    .stream()
                    .filter(jobSeedDto -> {
                        boolean isValid = validationUtil.isValid(jobSeedDto);
                        strBuilder.append(generateSeedResponse(
                                jobSeedDto.getJobTitle(), isValid));
                        return isValid;
                    })
                    .map(jobSeedDto -> {
                        Job job = modelMapper.map(jobSeedDto, Job.class);
                        Company company = companyService.findById(jobSeedDto.getCompanyId());
                        job.setCompany(company);
                        return job;
                    })
                    .forEach(jobRepository::save);
            return strBuilder.toString().trim();
        }
        return null;
    }

    private String generateSeedResponse(String name, boolean isValid) {
        return isValid
                ? String.format("Successfully imported job %s%s",
                name, System.lineSeparator())
                : String.format("Invalid job%s", System.lineSeparator());
    }

    @Override
    public String getBestJobs() {
    /* It does not populate the top result as in the example given in the Word document
       because it does not inject all entries from the xml for some reason...
       For example: "Job title: Media Manager II" is not part of the result, but not because
       of the validation (maybe some sort of hibernate timeout?)
       It's not validation issue, because if you insert the same position from a smaller file
       (i.e. "src/main/resources/files/xml/jobs2.xml" it inserts the record successfully in
       the "jobs" table...
     */

        StringBuilder sb = new StringBuilder();
        jobRepository
                .getAllBySalaryAboveAndWeeklyHoursBelow(5000d, 30d)
                .forEach(job -> {
                    sb.append(String.format("Job title: %s\n", job.getTitle()))
                            .append(String.format("-Salary: %.2f$\n", job.getSalary()))
                            .append(String.format("--Hours a week: %.2fh.\n", job.getHoursAWeek()))
                            .append(System.lineSeparator()).append(System.lineSeparator());
                });
        return sb.toString();
    }
}
