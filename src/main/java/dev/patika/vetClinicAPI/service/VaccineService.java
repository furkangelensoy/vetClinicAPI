package dev.patika.vetClinicAPI.service;

import dev.patika.vetClinicAPI.core.result.Result;
import dev.patika.vetClinicAPI.core.result.ResultData;
import dev.patika.vetClinicAPI.dto.request.vaccine.VaccineSaveRequest;
import dev.patika.vetClinicAPI.dto.request.vaccine.VaccineUpdateRequest;
import dev.patika.vetClinicAPI.dto.response.vaccine.VaccineResponse;

import java.time.LocalDate;
import java.util.List;

public interface VaccineService {
    //Methods that must be present in the VaccineService class are defined in this interface.

    ResultData<VaccineResponse> save(VaccineSaveRequest vaccineSaveRequest);

    ResultData<VaccineResponse> getById(Long id);

    Result delete(Long id);

    ResultData<VaccineResponse> update(Long id, VaccineUpdateRequest vaccineUpdateRequest);

    ResultData<List<VaccineResponse>> findByFilter(Long animalId);

    ResultData<List<VaccineResponse>> filterByFinishDate(LocalDate startDate, LocalDate endDate);
}
