package dev.patika.vetClinicAPI.service;

import dev.patika.vetClinicAPI.core.result.Result;
import dev.patika.vetClinicAPI.core.result.ResultData;
import dev.patika.vetClinicAPI.dto.request.availableDate.AvailableSaveRequest;
import dev.patika.vetClinicAPI.dto.request.availableDate.AvailableUpdateRequest;
import dev.patika.vetClinicAPI.dto.response.availableDate.AvailableResponse;

import java.util.List;

public interface AvailableDateService {
    ResultData<AvailableResponse> save(AvailableSaveRequest availableSaveRequest);

    ResultData<AvailableResponse> getById(Long id);

    Result delete(Long id);

    ResultData<AvailableResponse> update(Long id, AvailableUpdateRequest availableUpdateRequest);

    ResultData<List<AvailableResponse>> findAll();
}
