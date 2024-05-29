package dev.patika.vetClinicAPI.repository;

import dev.patika.vetClinicAPI.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    /*
    This interface extends the "JpaRepository" interface.
    It takes the create, update, delete and get functions of the Animal class from "JpaRepository".
    It also includes custom query functions.
     */


    /*
    This method filters animal data from the animal table according to customerId or animal Name.
    If no parameters are entered, it lists all animals.
     */
    @Query("SELECT a FROM Animal a " +
            "WHERE (:customerId IS NULL OR a.customer.id = :customerId) " +
            "AND (:animalName IS NULL OR a.name = :animalName)")
    List<Animal> findByFilter(Long customerId, String animalName);
}
