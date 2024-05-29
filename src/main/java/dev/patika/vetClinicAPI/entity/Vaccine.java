package dev.patika.vetClinicAPI.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "vaccines")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vaccine {

    /*
        This class corresponds to the vaccines table in the database.
        It contains the necessary columns in the vaccines table and contains the relationships of other tables.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String code;

    @Temporal(TemporalType.DATE)
    @Column(name = "protection_start_date")
    private LocalDate protectionStartDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "protection_finish_date")
    private LocalDate protectionFinishDate;

    /*
    This field contains the relationship between the vaccines table and the animals table.
    More than one vaccine can belong to one animal
    */
    @ManyToOne()
    @JoinColumn(name = "animal_id", referencedColumnName = "id")
    private Animal animal;
}
