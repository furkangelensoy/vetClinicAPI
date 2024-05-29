package dev.patika.vetClinicAPI.service;

import dev.patika.vetClinicAPI.core.result.Result;
import dev.patika.vetClinicAPI.core.result.ResultData;
import dev.patika.vetClinicAPI.dto.request.animal.AnimalSaveRequest;
import dev.patika.vetClinicAPI.dto.request.animal.AnimalUpdateRequest;
import dev.patika.vetClinicAPI.dto.response.animal.AnimalResponse;

import java.util.List;

public interface AnimalService {
    //Methods that must be present in the AnimalService class are defined in this interface.

    ResultData<AnimalResponse> save(AnimalSaveRequest animalSaveRequest);

    ResultData<AnimalResponse> getById(Long id);

    Result delete(Long id);

    ResultData<AnimalResponse> update(Long id, AnimalUpdateRequest animalUpdateRequest);

    ResultData<List<AnimalResponse>> findAll(Long id, String animalName);
}
