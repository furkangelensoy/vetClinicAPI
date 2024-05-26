package dev.patika.vetClinicAPI.core.config.mapper;

import dev.patika.vetClinicAPI.dto.request.doctor.DoctorSaveRequest;
import dev.patika.vetClinicAPI.dto.request.doctor.DoctorUpdateRequest;
import dev.patika.vetClinicAPI.dto.response.doctor.DoctorResponse;
import dev.patika.vetClinicAPI.entity.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    Doctor asEntity(DoctorSaveRequest doctorSaveRequest);

    List<DoctorResponse> asOutPutList(List<Doctor> doctorList);

    DoctorResponse asOutPut(Doctor doctor);

    void update(@MappingTarget Doctor entity, DoctorUpdateRequest doctorUpdateRequest);
}
