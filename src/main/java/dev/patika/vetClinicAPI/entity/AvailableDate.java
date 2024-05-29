package dev.patika.vetClinicAPI.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "available_dates")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AvailableDate {

    /*
        This class corresponds to the available_dates table in the database.
        It contains the necessary columns in the available_dates table and contains the relationships of other tables.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , columnDefinition = "serial")
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "available_date")
    private LocalDate availableDate;

    /*
    This field contains the relationship between the available_dates table and the doctors table.
    Only one available day can belong to the same doctor.
     */
    @ManyToOne()
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private Doctor doctor;
}
