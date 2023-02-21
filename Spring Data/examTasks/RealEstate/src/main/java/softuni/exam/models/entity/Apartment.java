package softuni.exam.models.entity;

import softuni.exam.models.entity.constraints.ApartmentType;

import javax.persistence.*;

@Entity
@Table(name="apartments")
public class Apartment extends BaseEntity {
    private ApartmentType apartmentType;
    private Double area;
    private Town town;

    @ManyToOne
    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public Apartment() {
    }

    @Column(name="apartment_type")
    @Enumerated(EnumType.STRING)
    public ApartmentType getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(ApartmentType apartmentType) {
        this.apartmentType = apartmentType;
    }

    @Column
    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }
}
