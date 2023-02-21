package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Offer;

import java.util.List;

// TODO:
@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
    @Query("Select o from Offer o " +
            "where o.apartment.apartmentType = 'three_rooms' " +
            "order by o.apartment.area desc, o.price")
    List<Offer> findThreeRoomApartmentsOrderByApartmentAreaDescPriceAsc();
}
