package dev.patika.vetClinicAPI.repository;

import dev.patika.vetClinicAPI.entity.AvailableDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface AvailableDateRepository extends JpaRepository<AvailableDate, Long> {
    /*
    This interface extends the "JpaRepository" interface.
    It takes the create, update, delete and get functions of the AvilableDate class from "JpaRepository".
    It also includes custom query functions.
    */

    /*
    This method checks AvailableDate according to the entered date and doctorId.
     */
    @Query("SELECT a FROM AvailableDate a " +
            "WHERE a.availableDate = :date " +
            "AND a.doctor.id = :doctorId")
    Optional<AvailableDate> findByDate(LocalDate date, Long doctorId);


}
