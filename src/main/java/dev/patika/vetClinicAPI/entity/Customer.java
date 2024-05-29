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
@Table(name = "customers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    /*
        This class corresponds to the customers table in the database.
        It contains the necessary columns in the customers table and contains the relationships of other tables.
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
    This field contains the relationship between the customers table and the animals table.
    A customer can have more than one animal.
    Cascade type remove is defined so that when a customer is deleted from the database,
    the animals of the customer are deleted.
    */
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Animal> animalList;

}
