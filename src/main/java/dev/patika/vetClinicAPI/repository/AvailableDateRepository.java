package dev.patika.vetClinicAPI.repository;

import dev.patika.vetClinicAPI.entity.AvailableDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface AvailableDateRepository extends JpaRepository<AvailableDate,Long> {
    @Query("SELECT a FROM AvailableDate a " +
            "WHERE a.availableDate = :date " +
            "AND a.doctor.id = :doctorId")
    Optional<AvailableDate> findByDate(LocalDate date, Long doctorId);


}
