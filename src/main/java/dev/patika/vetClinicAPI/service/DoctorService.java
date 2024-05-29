package dev.patika.vetClinicAPI.service;

import dev.patika.vetClinicAPI.core.result.Result;
import dev.patika.vetClinicAPI.core.result.ResultData;
import dev.patika.vetClinicAPI.dto.request.doctor.DoctorSaveRequest;
import dev.patika.vetClinicAPI.dto.request.doctor.DoctorUpdateRequest;
import dev.patika.vetClinicAPI.dto.response.doctor.DoctorResponse;

import java.util.List;

public interface DoctorService {
    //Methods that must be present in the DoctorService class are defined in this interface.

    ResultData<DoctorResponse> save(DoctorSaveRequest doctorSaveRequest);

    ResultData<DoctorResponse> getById(Long id);

    Result delete(Long id);

    ResultData<DoctorResponse> update(Long id, DoctorUpdateRequest doctorUpdateRequest);

    ResultData<List<DoctorResponse>> findAll();
}
