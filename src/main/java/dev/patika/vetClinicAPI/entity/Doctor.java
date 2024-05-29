package dev.patika.vetClinicAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "doctors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    /*
        This class corresponds to the doctors table in the database.
        It contains the necessary columns in the doctors table and contains the relationships of other tables.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String phone;

    @Email
    @Column(nullable = false)
    private String mail;

    @Column
    private String address;

    @Column
    private String city;

    /*
    This field contains the relationship between the doctors table and the appointments table.
    A doctor may have more than one appointment.
    Cascade type remove is defined so that when a doctor is deleted from the database,
    the appointments of the doctor are deleted.
    */
    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Appointment> appointmentList;


    /*
    This field contains the relationship between the doctors table and the available_dates table.
    A doctor may have more than one available_date.
    Cascade type remove is defined so that when a doctor is deleted from the database,
    the available_dates of the doctor are deleted.
    */
    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<AvailableDate> availableDateList;
}
