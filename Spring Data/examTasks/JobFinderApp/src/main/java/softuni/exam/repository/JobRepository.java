package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Job;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    @Query("Select j from Job j " +
           "where j.salary >= :minSalary " +
           "and j.hoursAWeek <= :weeklyHours " +
           "order by j.salary desc")
    List<Job> getAllBySalaryAboveAndWeeklyHoursBelow(Double minSalary, Double weeklyHours);

}
