package dev.patika.vetClinicAPI.repository;

import dev.patika.vetClinicAPI.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    /*
    This interface extends the "JpaRepository" interface.
    It takes the create, update, delete and get functions of the Customer class from "JpaRepository".
    It also includes custom query functions.
    */

    /*
    This method lists customer data from the customer table according to customerName.
     */
    @Query("SELECT c FROM Customer c " +
            "WHERE :customerName IS NULL OR c.name = :customerName")
    List<Customer> findByFilter(String customerName);
}
