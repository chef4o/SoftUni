package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByFirstName(String firstName);
    Person findByPhone(String phone);
    Person findByEmail(String email);
}
