package dev.patika.vetClinicAPI.repository;

import dev.patika.vetClinicAPI.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    /*
    This interface extends the "JpaRepository" interface.
    It takes the create, update, delete and get functions of the Doctor class from "JpaRepository".
     */
}
