package dev.patika.vetClinicAPI.core.config.mapper;

import dev.patika.vetClinicAPI.dto.request.animal.AnimalSaveRequest;
import dev.patika.vetClinicAPI.dto.request.animal.AnimalUpdateRequest;
import dev.patika.vetClinicAPI.dto.response.animal.AnimalResponse;
import dev.patika.vetClinicAPI.entity.Animal;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnimalMapper {
    Animal asEntity(AnimalSaveRequest animalSaveRequest);

    List<AnimalResponse> asOutPutList(List<Animal> animalList);

    AnimalResponse asOutPut(Animal animal);

    void update(@MappingTarget Animal entity, AnimalUpdateRequest animalUpdateRequest);
}
