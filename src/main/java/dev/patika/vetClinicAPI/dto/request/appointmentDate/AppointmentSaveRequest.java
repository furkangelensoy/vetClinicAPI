package dev.patika.vetClinicAPI.dto.request.appointmentDate;


import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AppointmentSaveRequest {
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime appointmentDate;

    @Positive(message = "Id must be positive value")
    private Long animalId;

    @Positive(message = "Id must be positive value")
    private Long doctorId;
}
