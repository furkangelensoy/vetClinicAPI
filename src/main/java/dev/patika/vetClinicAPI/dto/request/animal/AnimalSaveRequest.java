package dev.patika.vetClinicAPI.dto.request.animal;


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
public class AnimalSaveRequest {
    @NotBlank(message = "Name cannot be left blank")
    private String name;

    private String species;
    private String breed;
    private String gender;
    private String color;
    private LocalDate birthDate;

    @Positive(message = "Id must be positive value")
    private Long customerId;
}
