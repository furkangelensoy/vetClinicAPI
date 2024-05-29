package dev.patika.vetClinicAPI.repository;

import dev.patika.vetClinicAPI.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Long> {
    /*
    This interface extends the "JpaRepository" interface.
    It takes the create, update, delete and get functions of the Vaccine class from "JpaRepository".
    It also includes custom query functions.
     */


    /*
    This method gets vaccine's count according to animalId, vaccineName, vaccineCode, startDate and endDate.
    If the count is different from 0, the animal has this vaccine and the protection period has not expired yet.
     */
    @Query("SELECT COUNT(v) FROM Vaccine v " +
            "WHERE (v.animal.id = :animalId) " +
            "AND (v.name = :vaccineName) " +
            "AND (v.code = :vaccineCode) " +
            "AND (v.protectionStartDate <= :endDate) " +
            "AND (v.protectionFinishDate >= :startDate)")
    int findHasVaccine(Long animalId, String vaccineName, String vaccineCode, LocalDate startDate, LocalDate endDate);


    /*
    This method lists vaccines data from the vaccine table according to animalId.
     */
    @Query("SELECT v FROM Vaccine v " +
            "WHERE (:animalId IS NULL OR v.animal.id = :animalId)")
    List<Vaccine> findByFilter(Long animalId);


    /*
    This method lists vaccines data from the vaccine table according to startDate and endDate.
     */
    @Query("SELECT v FROM Vaccine v " +
            "WHERE v.protectionFinishDate BETWEEN :startDate AND :endDate")
    List<Vaccine> filterByFinishDate(LocalDate startDate, LocalDate endDate);
}
