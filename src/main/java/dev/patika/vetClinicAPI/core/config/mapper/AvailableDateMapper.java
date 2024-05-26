package dev.patika.vetClinicAPI.core.config.mapper;

import dev.patika.vetClinicAPI.dto.request.availableDate.AvailableSaveRequest;
import dev.patika.vetClinicAPI.dto.request.availableDate.AvailableUpdateRequest;
import dev.patika.vetClinicAPI.dto.response.availableDate.AvailableResponse;
import dev.patika.vetClinicAPI.entity.AvailableDate;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AvailableDateMapper {
    AvailableDate asEntity(AvailableSaveRequest availableSaveRequest);

    List<AvailableResponse> asOutPutList(List<AvailableDate> availableDateList);

    AvailableResponse asOutPut(AvailableDate availableDate);

    void update(@MappingTarget AvailableDate entity, AvailableUpdateRequest availableUpdateRequest);
}
