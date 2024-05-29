package dev.patika.vetClinicAPI.controller;

import dev.patika.vetClinicAPI.core.result.Result;
import dev.patika.vetClinicAPI.core.result.ResultData;
import dev.patika.vetClinicAPI.dto.request.vaccine.VaccineSaveRequest;
import dev.patika.vetClinicAPI.dto.request.vaccine.VaccineUpdateRequest;
import dev.patika.vetClinicAPI.dto.response.vaccine.VaccineResponse;
import dev.patika.vetClinicAPI.service.serviceImpl.VaccineService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/vaccines")
@RequiredArgsConstructor
public class VaccineController {

    private final VaccineService vaccineService;

    @GetMapping("/{id}")
    public ResultData<VaccineResponse> getById(@PathVariable Long id) {
        //This method gets a vaccine from the database according to the id.

        return this.vaccineService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<VaccineResponse> save(@Valid @RequestBody VaccineSaveRequest vaccineSaveRequest) {
        //This method saves a vaccine to the database according to the vaccineSaveRequest.

        return this.vaccineService.save(vaccineSaveRequest);
    }

    @PutMapping("/{id}")
    public ResultData<VaccineResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody VaccineUpdateRequest vaccineUpdateRequest) {

        return this.vaccineService.update(id, vaccineUpdateRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Result delete(@PathVariable Long id) {
        //This method deletes a vaccine from the database according to the id.

        return this.vaccineService.delete(id);
    }

    @GetMapping
    public ResultData<List<VaccineResponse>> findAll(
            @RequestParam(required = false) Long animalId) {
        //This method lists all vaccines from the database.
        //If parameter is entered it lists according to animalId.

        return this.vaccineService.findByFilter(animalId);
    }

    @GetMapping("/filter-by-date")
    public ResultData<List<VaccineResponse>> filterByFinishDate(
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {
        //This method lists vaccines from the database according to startDate and endDate.

        return this.vaccineService.filterByFinishDate(startDate, endDate);
    }
}
