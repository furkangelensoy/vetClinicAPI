package dev.patika.vetClinicAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "animals")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String species;

    @Column
    private String breed;

    @Column
    private String gender;

    @Column
    private String color;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "customer_id" , referencedColumnName = "id")
    private Customer customer;

    @OneToMany(mappedBy = "animal")
    @JsonIgnore
    private List<Appointment> appointmentList;

    @OneToMany(mappedBy = "animal")
    @JsonIgnore
    private List<Vaccine> vaccineList;
}
