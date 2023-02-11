package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Forecast;
import softuni.exam.models.entity.constants.DayOfWeek;

import java.util.List;

@Repository
public interface ForecastRepository extends JpaRepository<Forecast, Long> {

    @Query("Select f from Forecast f " +
            "where f.dayOfWeek = :dayOfWeek " +
            "and f.city.population < :citizensCount " +
            "order by f.maxTemperature desc, f.id")
    List<Forecast> findAllFromSundayWhereCityPopulationBelow(DayOfWeek dayOfWeek, int citizensCount);
}
