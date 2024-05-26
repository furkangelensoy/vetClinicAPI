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
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

    @Query("SELECT a FROM Appointment a " +
            "WHERE a.appointmentDate = :date " +
            "AND a.doctor.id = :doctorId")
    Optional<Appointment> findByDate(LocalDateTime date, Long doctorId);

    @Query("SELECT a FROM Appointment a " +
            "WHERE DATE(a.appointmentDate) BETWEEN :startDate AND :endDate " +
            "AND a.animal.id = :animalId")
    List<Appointment> findByDateRangeAndAnimalId(LocalDate startDate, LocalDate endDate, Long animalId);


    @Query("SELECT a FROM Appointment a " +
            "WHERE DATE(a.appointmentDate) BETWEEN :startDate AND :endDate " +
            "AND a.doctor.id = :doctorId")
    List<Appointment> findByDateRangeAndDoctorId(LocalDate startDate, LocalDate endDate, Long doctorId);
}
