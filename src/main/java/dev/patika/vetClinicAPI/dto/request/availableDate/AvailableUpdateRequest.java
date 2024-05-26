package dev.patika.vetClinicAPI.dto.request.availableDate;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AvailableUpdateRequest {
    @Temporal(TemporalType.DATE)
    private LocalDate availableDate;

    @Positive(message = "Id must be positive value")
    private Long doctorId;
}
