package dev.patika.vetClinicAPI.repository;

import dev.patika.vetClinicAPI.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    /*
    This interface extends the "JpaRepository" interface.
    It takes the create, update, delete and get functions of the Appointment class from "JpaRepository".
    It also includes custom query functions.
     */


    /*
    This method checks the existence of an appointment in the appointment table according to the entered date and doctorId.
     */
    @Query("SELECT a FROM Appointment a " +
            "WHERE a.appointmentDate = :date " +
            "AND a.doctor.id = :doctorId")
    Optional<Appointment> findByDate(LocalDateTime date, Long doctorId);

    /*
    This method lists appointment data from the appointment table according to startDate, endDate and animalId.
     */
    @Query("SELECT a FROM Appointment a " +
            "WHERE DATE(a.appointmentDate) BETWEEN :startDate AND :endDate " +
            "AND a.animal.id = :animalId")
    List<Appointment> findByDateRangeAndAnimalId(LocalDate startDate, LocalDate endDate, Long animalId);

    /*
    This method lists appointment data from the appointment table according to startDate, endDate and doctorId.
     */
    @Query("SELECT a FROM Appointment a " +
            "WHERE DATE(a.appointmentDate) BETWEEN :startDate AND :endDate " +
            "AND a.doctor.id = :doctorId")
    List<Appointment> findByDateRangeAndDoctorId(LocalDate startDate, LocalDate endDate, Long doctorId);
}
