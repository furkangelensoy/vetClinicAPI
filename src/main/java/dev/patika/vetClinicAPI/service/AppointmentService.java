package dev.patika.vetClinicAPI.service;

import dev.patika.vetClinicAPI.core.result.Result;
import dev.patika.vetClinicAPI.core.result.ResultData;
import dev.patika.vetClinicAPI.dto.request.appointmentDate.AppointmentSaveRequest;
import dev.patika.vetClinicAPI.dto.request.appointmentDate.AppointmentUpdateRequest;
import dev.patika.vetClinicAPI.dto.response.appointmentDate.AppointmentResponse;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {
    ResultData<AppointmentResponse> save(AppointmentSaveRequest appointmentSaveRequest);

    ResultData<AppointmentResponse> getById(Long id);

    Result delete(Long id);

    ResultData<AppointmentResponse> update(Long id, AppointmentUpdateRequest appointmentUpdateRequest);

    ResultData<List<AppointmentResponse>> findAll();

    ResultData<List<AppointmentResponse>> findByDateRangeAndAnimalId(LocalDate startDate, LocalDate endDate, Long animalId);

    ResultData<List<AppointmentResponse>> findByDateRangeAndDoctorId(LocalDate startDate, LocalDate endDate, Long doctorId);
}
