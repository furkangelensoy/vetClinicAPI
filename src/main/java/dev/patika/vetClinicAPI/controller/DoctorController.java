package dev.patika.vetClinicAPI.controller;

import dev.patika.vetClinicAPI.core.result.Result;
import dev.patika.vetClinicAPI.core.result.ResultData;
import dev.patika.vetClinicAPI.dto.request.doctor.DoctorSaveRequest;
import dev.patika.vetClinicAPI.dto.request.doctor.DoctorUpdateRequest;
import dev.patika.vetClinicAPI.dto.response.doctor.DoctorResponse;
import dev.patika.vetClinicAPI.service.serviceImpl.DoctorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping("/{id}")
    public ResultData<DoctorResponse> getById(@PathVariable Long id) {
        //This method gets a doctor from the database according to the id.

        return this.doctorService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<DoctorResponse> save(@Valid @RequestBody DoctorSaveRequest doctorSaveRequest) {
        //This method saves a doctor to the database according to the doctorSaveRequest.

        return this.doctorService.save(doctorSaveRequest);
    }

    @PutMapping("/{id}")
    public ResultData<DoctorResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody DoctorUpdateRequest doctorUpdateRequest) {
        //This method updates a doctor from the database according to the id and doctorUpdateRequest.

        return this.doctorService.update(id, doctorUpdateRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Result delete(@PathVariable Long id) {
        //This method deletes a doctor from the database according to the id.

        return this.doctorService.delete(id);
    }

    @GetMapping
    public ResultData<List<DoctorResponse>> findAll() {
        //This method lists all doctors from the database.

        return this.doctorService.findAll();
    }
}
