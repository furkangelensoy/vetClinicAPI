package dev.patika.vetClinicAPI.dto.request.doctor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DoctorSaveRequest {
    @NotBlank(message = "Name cannot be left blank")
    private String name;

    private String phone;

    @Email(message = "Must be in email format")
    @NotBlank(message = "Mail cannot be left blank")
    private String mail;

    private String address;
    private String city;
}
