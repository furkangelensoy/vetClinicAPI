package dev.patika.vetClinicAPI.core.config.mapper;

import dev.patika.vetClinicAPI.dto.request.appointmentDate.AppointmentSaveRequest;
import dev.patika.vetClinicAPI.dto.request.appointmentDate.AppointmentUpdateRequest;
import dev.patika.vetClinicAPI.dto.response.appointmentDate.AppointmentResponse;
import dev.patika.vetClinicAPI.entity.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppointmentDateMapper {
    Appointment asEntity(AppointmentSaveRequest appointmentSaveRequest);

    List<AppointmentResponse> asOutPutList(List<Appointment> appointmentList);

    AppointmentResponse asOutPut(Appointment appointment);

    void update(@MappingTarget Appointment entity, AppointmentUpdateRequest appointmentUpdateRequest);
}
