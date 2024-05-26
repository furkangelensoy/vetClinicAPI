package dev.patika.vetClinicAPI.repository;

import dev.patika.vetClinicAPI.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine,Long> {
    @Query("SELECT COUNT(v) FROM Vaccine v " +
            "WHERE (v.animal.id = :animalId) " +
            "AND (v.name = :vaccineName) " +
            "AND (v.code = :vaccineCode) " +
            "AND (v.protectionStartDate <= :finishDate) " +
            "AND (v.protectionFinishDate >= :startDate)")
    int findHasVaccine(Long animalId, String vaccineName, String vaccineCode, LocalDate startDate, LocalDate finishDate);

    @Query("SELECT v FROM Vaccine v " +
            "WHERE (:animalId IS NULL OR v.animal.id = :animalId)")
    List<Vaccine> findByFilter(Long animalId);


    @Query("SELECT v FROM Vaccine v " +
            "WHERE v.protectionFinishDate BETWEEN :startDate AND :endDate")
    List<Vaccine> filterByFinishDate(LocalDate startDate, LocalDate endDate);
}
