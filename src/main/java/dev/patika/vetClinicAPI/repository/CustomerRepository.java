package dev.patika.vetClinicAPI.repository;

import dev.patika.vetClinicAPI.entity.Animal;
import dev.patika.vetClinicAPI.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Query("SELECT c FROM Customer c " +
            "WHERE :customerName IS NULL OR c.name = :customerName")
    List<Customer> findByFilter(String customerName);
}
