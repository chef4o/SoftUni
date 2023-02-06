package com.example.football.repository;

import com.example.football.models.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query("Select p from Player p where p.birthDate between :startDate and :endDate " +
            "order by p.stat.shooting desc, p.stat.passing desc, p.stat.endurance desc, p.lastName")
    List<Player> findAllByBirthdayBetweenOrderByShootingDescPassingDescEnduranceDescLastName(
            LocalDate startDate, LocalDate endDate);
}
