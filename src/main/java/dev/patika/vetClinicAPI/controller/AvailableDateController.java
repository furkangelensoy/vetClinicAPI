package dev.patika.vetClinicAPI.controller;

import dev.patika.vetClinicAPI.core.result.Result;
import dev.patika.vetClinicAPI.core.result.ResultData;
import dev.patika.vetClinicAPI.dto.request.availableDate.AvailableSaveRequest;
import dev.patika.vetClinicAPI.dto.request.availableDate.AvailableUpdateRequest;
import dev.patika.vetClinicAPI.dto.response.availableDate.AvailableResponse;
import dev.patika.vetClinicAPI.service.serviceImpl.AvailableDateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/available-dates")
@RequiredArgsConstructor
public class AvailableDateController {

    private final AvailableDateService availableDateService;

    @GetMapping("/{id}")
    public ResultData<AvailableResponse> getById(@PathVariable Long id) {
        //This method gets an available date from the database according to the id.

        return this.availableDateService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AvailableResponse> save(@Valid @RequestBody AvailableSaveRequest availableSaveRequest) {
        //This method saves an available date to the database according to the availableSaveRequest.

        return this.availableDateService.save(availableSaveRequest);
    }

    @PutMapping("/{id}")
    public ResultData<AvailableResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody AvailableUpdateRequest availableUpdateRequest) {
        //This method updates an available date from the database according to the id and availableUpdateRequest.

        return this.availableDateService.update(id, availableUpdateRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Result delete(@PathVariable Long id) {
        //This method deletes an available date from the database according to the id.

        return this.availableDateService.delete(id);
    }

    @GetMapping
    public ResultData<List<AvailableResponse>> findAll() {
        //This method lists all available dates from the database.

        return this.availableDateService.findAll();
    }
}
