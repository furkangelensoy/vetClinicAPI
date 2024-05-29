package dev.patika.vetClinicAPI.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    /*
        This class corresponds to the appointments table in the database.
        It contains the necessary columns in the appointments table and contains the relationships of other tables.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Long id;


    @Column(name = "appointment_date")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime appointmentDate;

    /*
    This field contains the relationship between the appointments table and the animal table.
    An appointment can only belong to one animal.
     */
    @ManyToOne()
    @JoinColumn(name = "animal_id", referencedColumnName = "id")
    private Animal animal;

    /*
    This field contains the relationship between the appointments table and the doctors table.
    There can only be one same doctor for an appointment.
     */
    @ManyToOne()
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private Doctor doctor;
}
