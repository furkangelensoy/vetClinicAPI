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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , columnDefinition = "serial")
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

    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    private List<Appointment> appointmentList;

    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    private List<AvailableDate> availableDateList;
}
