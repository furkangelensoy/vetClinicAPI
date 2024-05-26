package dev.patika.vetClinicAPI.core.config.mapper;


import dev.patika.vetClinicAPI.dto.request.vaccine.VaccineSaveRequest;
import dev.patika.vetClinicAPI.dto.request.vaccine.VaccineUpdateRequest;
import dev.patika.vetClinicAPI.dto.response.vaccine.VaccineResponse;
import dev.patika.vetClinicAPI.entity.Vaccine;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VaccineMapper {
    Vaccine asEntity(VaccineSaveRequest vaccineSaveRequest);

    List<VaccineResponse> asOutPutList(List<Vaccine> vaccineList);

    VaccineResponse asOutPut(Vaccine vaccine);

    void update(@MappingTarget Vaccine entity, VaccineUpdateRequest vaccineUpdateRequest);
}
