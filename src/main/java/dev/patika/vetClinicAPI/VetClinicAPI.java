package dev.patika.vetClinicAPI;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Vet Clinic App", version = "1.0", description = "Vet Clinic Management System"))
public class VetClinicAPI {

    public static void main(String[] args) {
        SpringApplication.run(VetClinicAPI.class, args);
    }

}
