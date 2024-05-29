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
        //This method gets an animal from the database according to the id.

        return this.animalService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AnimalResponse> save(@Valid @RequestBody AnimalSaveRequest animalSaveRequest) {
        //This method saves an animal to the database according to the animalSaveRequest.

        return this.animalService.save(animalSaveRequest);
    }

    @PutMapping("/{id}")
    public ResultData<AnimalResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody AnimalUpdateRequest animalUpdateRequest) {
        //This method updates an animal from the database according to the id and AnimalUpdateRequest.

        return this.animalService.update(id, animalUpdateRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Result delete(@PathVariable Long id) {
        //This method deletes an animal from the database according to the id.

        return this.animalService.delete(id);
    }

    @GetMapping
    public ResultData<List<AnimalResponse>> findAll(
            @RequestParam(required = false) Long customerId,
            @RequestParam(required = false) String animalName) {
        //This method lists animals from the database according to the customerId and animalName.
        //If no parameters are entered, it lists all animals.

        return this.animalService.findAll(customerId, animalName);
    }
}
