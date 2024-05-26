package dev.patika.vetClinicAPI.repository;

import dev.patika.vetClinicAPI.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal,Long> {

    @Query("SELECT a FROM Animal a " +
            "WHERE (:customerId IS NULL OR a.customer.id = :customerId) " +
            "AND (:animalName IS NULL OR a.name = :animalName)")
    List<Animal> findByFilter(Long customerId, String animalName);
}
