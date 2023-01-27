package softuni.exam.models.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="pictures")
public class Picture extends BaseEntity {

    private String name;
    private LocalDateTime dateAndTime;
    private Car car;

    @ManyToOne
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Picture() {
    }

    @Column(name="name", unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="date_and_time")
    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }
}
