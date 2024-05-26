package dev.patika.vetClinicAPI.dto.request.vaccine;

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
public class VaccineUpdateRequest {
    @NotBlank(message = "Name cannot be left blank")
    private String name;

    @NotBlank(message = "Code cannot be blank")
    private String code;

    @Temporal(TemporalType.DATE)
    private LocalDate protectionStartDate;

    @Temporal(TemporalType.DATE)
    private LocalDate protectionFinishDate;

    @Positive(message = "Id must be positive value")
    private Long animalId;
}
