package dev.patika.vetClinicAPI.controller;

import dev.patika.vetClinicAPI.core.result.Result;
import dev.patika.vetClinicAPI.core.result.ResultData;
import dev.patika.vetClinicAPI.dto.request.animal.AnimalSaveRequest;
import dev.patika.vetClinicAPI.dto.request.animal.AnimalUpdateRequest;
import dev.patika.vetClinicAPI.dto.response.animal.AnimalResponse;
import dev.patika.vetClinicAPI.service.serviceImpl.AnimalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/animals")
@RequiredArgsConstructor
public class AnimalController {

    private final AnimalService animalService;

    @GetMapping("/{id}")
    public ResultData<AnimalResponse> getById(@PathVariable Long id) {
        return this.animalService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AnimalResponse> save(@Valid @RequestBody AnimalSaveRequest animalSaveRequest) {
        return this.animalService.save(animalSaveRequest);
    }

    @PutMapping("/{id}")
    public ResultData<AnimalResponse> update(
            @PathVariable Long id, @Valid @RequestBody AnimalUpdateRequest animalUpdateRequest) {
        return this.animalService.update(id, animalUpdateRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Result delete(@PathVariable Long id) {
        return this.animalService.delete(id);
    }

    @GetMapping
    public ResultData<List<AnimalResponse>> findAll(
            @RequestParam(required = false) Long customerId,
            @RequestParam(required = false) String animalName) {
        return this.animalService.findAll(customerId, animalName);
    }
}
