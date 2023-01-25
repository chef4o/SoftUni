package softuni.exam.models.entity;

import softuni.exam.models.entity.constraints.StatusType;

import javax.persistence.*;

@Entity
@Table(name="people")
public class Person extends BaseEntity {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private StatusType statusType;
    private Country country;
    public Person() {
    }

    @Column(name="first_name", unique = true)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name="last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(unique = true)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name="status_type")
    @Enumerated
    public StatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(StatusType statusType) {
        this.statusType = statusType;
    }

    @ManyToOne
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
