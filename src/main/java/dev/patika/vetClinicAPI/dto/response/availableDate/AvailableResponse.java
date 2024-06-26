package dev.patika.vetClinicAPI.dto.response.availableDate;

import dev.patika.vetClinicAPI.entity.Doctor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AvailableResponse {
    private Long id;
    private LocalDate availableDate;
    private Doctor doctor;
}
