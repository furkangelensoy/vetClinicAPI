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
    /*
        This class corresponds to the animals table in the database.
        It contains the necessary columns in the animals table and contains the relationships of other tables.
     */


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


    /*
    This field contains the relationship between the animal table and the customer table.
    An animal may have one owner, but a customer may have more than one animal.
    */
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;


    /*
    This field contains the relationship between the animal table and the appointments table.
    There may be more than one appointment for an animal.
    Cascade type remove is defined so that when an animal is deleted from the database,
    the appointments of the animal are deleted.
    */
    @OneToMany(mappedBy = "animal", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Appointment> appointmentList;

    /*
    This field contains the relationship between the animal table and the vaccines table.
    An animal may have more than one vaccination.
    Cascade type remove is defined so that when an animal is deleted from the database,
    the vaccines of the animal are deleted.
    */
    @OneToMany(mappedBy = "animal", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Vaccine> vaccineList;
}
