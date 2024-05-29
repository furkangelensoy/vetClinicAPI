package dev.patika.vetClinicAPI.controller;

import dev.patika.vetClinicAPI.core.result.Result;
import dev.patika.vetClinicAPI.core.result.ResultData;
import dev.patika.vetClinicAPI.dto.request.appointmentDate.AppointmentSaveRequest;
import dev.patika.vetClinicAPI.dto.request.appointmentDate.AppointmentUpdateRequest;
import dev.patika.vetClinicAPI.dto.response.appointmentDate.AppointmentResponse;
import dev.patika.vetClinicAPI.service.serviceImpl.AppointmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping("/{id}")
    public ResultData<AppointmentResponse> getById(@PathVariable Long id) {
        //This method gets an appointment from the database according to the id.

        return this.appointmentService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AppointmentResponse> save(@Valid @RequestBody AppointmentSaveRequest appointmentSaveRequest) {
        //This method saves an appointment to the database according to the appointmentSaveRequest.

        return this.appointmentService.save(appointmentSaveRequest);
    }

    @PutMapping("/{id}")
    public ResultData<AppointmentResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody AppointmentUpdateRequest appointmentUpdateRequest) {
        //This method saves an appointment to the database according to the id and appointmentSaveRequest.

        return this.appointmentService.update(id, appointmentUpdateRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Result delete(@PathVariable Long id) {
        //This method deletes an appointment from the database according to the id.

        return this.appointmentService.delete(id);
    }

    @GetMapping
    public ResultData<List<AppointmentResponse>> findAll() {
        //This method lists all appointments from the database.

        return this.appointmentService.findAll();
    }

    @GetMapping("/get-by-animal")
    public ResultData<List<AppointmentResponse>> getByDateRangeAndAnimalId(
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate,
            @RequestParam Long animalId) {
        //This method lists appointments from the database according to startDate, endDate and animalId.


        return this.appointmentService.findByDateRangeAndAnimalId(startDate, endDate, animalId);
    }

    @GetMapping("/get-by-doctor")
    public ResultData<List<AppointmentResponse>> findByDateRangeAndDoctorId(
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate,
            @RequestParam Long doctorId) {
        //This method lists appointments from the database according to startDate, endDate and doctorId.

        return this.appointmentService.findByDateRangeAndDoctorId(startDate, endDate, doctorId);
    }
}
