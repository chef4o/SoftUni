package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PersonSeedDto;
import softuni.exam.models.entity.Country;
import softuni.exam.models.entity.Person;
import softuni.exam.models.entity.constraints.StatusType;
import softuni.exam.repository.PersonRepository;
import softuni.exam.service.CountryService;
import softuni.exam.service.PersonService;
import softuni.exam.util.ValidationUtil;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class PersonServiceImpl implements PersonService {
    private static final String PEOPLE_SEED_FILE_JSON = "src/main/resources/files/json/people.json";
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final PersonRepository personRepository;
    private final CountryService countryService;

    public PersonServiceImpl(PersonRepository personRepository, ValidationUtil validationUtil,
                             ModelMapper modelMapper, Gson gson, CountryService countryService) {
        this.personRepository = personRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.countryService = countryService;
    }

    @Override
    public boolean areImported() {
        return personRepository.count() > 0;
    }

    @Override
    public String readPeopleFromFile() throws IOException {
        return Files.readString(Path.of(PEOPLE_SEED_FILE_JSON));
    }

    @Override
    public String importPeople() throws IOException, JAXBException {
        if (!areImported()) {
            StringBuilder output = new StringBuilder();
            Arrays.stream(gson
                            .fromJson(readPeopleFromFile(), PersonSeedDto[].class))
                    .filter(personSeedDto -> {
                        boolean isValid = validationUtil.isValid(personSeedDto)
                                && isNonExistingEntity(personSeedDto.getFirstName(),
                                                        personSeedDto.getEmail(),
                                                        personSeedDto.getPhone())
                                && validationUtil.enumContains(StatusType.class,
                                                                personSeedDto.getStatusType());
                        System.out.println();
                        output.append(generateSeedResponse(personSeedDto.getFirstName(),
                                personSeedDto.getLastName(), isValid));
                        return isValid;
                    })
                    .map(personSeedDto -> {
                        Person person = modelMapper.map(personSeedDto, Person.class);
                        Country country = countryService.findById(personSeedDto.getCountry());
                        person.setCountry(country);
                        return person;
                    })
                    .forEach(personRepository::save);

            return output.toString().trim();
        }
        return null;
    }

    private boolean isNonExistingEntity(String firstName, String email, String phone) {
        return personRepository.findByFirstName(firstName) == null
                && personRepository.findByEmail(email) == null
                && personRepository.findByPhone(phone) == null;
    }

    private String generateSeedResponse(String fName, String lName, boolean isValid) {
        return isValid
                ? String.format("Successfully imported person %s %s%s",
                fName, lName, System.lineSeparator())
                : String.format("Invalid person%s", System.lineSeparator());
    }
}
