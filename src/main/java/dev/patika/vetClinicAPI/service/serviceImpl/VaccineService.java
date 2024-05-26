package dev.patika.vetClinicAPI.service.serviceImpl;

import dev.patika.vetClinicAPI.core.exception.NotFoundException;
import dev.patika.vetClinicAPI.core.exception.VaccineExpiredException;
import dev.patika.vetClinicAPI.core.result.Result;
import dev.patika.vetClinicAPI.core.result.ResultData;
import dev.patika.vetClinicAPI.core.utils.ResultHelper;
import dev.patika.vetClinicAPI.dto.request.vaccine.VaccineSaveRequest;
import dev.patika.vetClinicAPI.dto.request.vaccine.VaccineUpdateRequest;
import dev.patika.vetClinicAPI.dto.response.vaccine.VaccineResponse;
import dev.patika.vetClinicAPI.entity.Animal;
import dev.patika.vetClinicAPI.entity.Vaccine;
import dev.patika.vetClinicAPI.core.config.mapper.VaccineMapper;
import dev.patika.vetClinicAPI.repository.AnimalRepository;
import dev.patika.vetClinicAPI.repository.VaccineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VaccineService implements dev.patika.vetClinicAPI.service.VaccineService {

    private final VaccineRepository vaccineRepository;
    private final VaccineMapper vaccineMapper;
    private final AnimalRepository animalRepository;

    @Override
    public ResultData<VaccineResponse> save(VaccineSaveRequest vaccineSaveRequest) {
        Long animalId = vaccineSaveRequest.getAnimalId();
        Animal animal = this.animalRepository.findById(animalId)
                .orElseThrow(() -> new NotFoundException(String.valueOf(animalId)));


        int vaccineCount = this.vaccineRepository.findHasVaccine(
                vaccineSaveRequest.getAnimalId(),
                vaccineSaveRequest.getName(),
                vaccineSaveRequest.getCode(),
                vaccineSaveRequest.getProtectionStartDate(),
                vaccineSaveRequest.getProtectionFinishDate()
        );

        if (vaccineCount > 0) {
            throw new VaccineExpiredException();
        }


        Vaccine vaccine = this.vaccineMapper.asEntity(vaccineSaveRequest);
        vaccine.setAnimal(animal);

        Vaccine savedVaccine = this.vaccineRepository.save(vaccine);

        VaccineResponse vaccineResponse = this.vaccineMapper.asOutPut(savedVaccine);
        vaccineResponse.setAnimalId(animalId);

        return ResultHelper.CREATED(vaccineResponse);
    }

    @Override
    public ResultData<VaccineResponse> getById(Long id) {
        Vaccine vaccine = this.vaccineRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.valueOf(id)));

        VaccineResponse vaccineResponse = this.vaccineMapper.asOutPut(vaccine);
        vaccineResponse.setAnimalId(vaccine.getAnimal().getId());

        return ResultHelper.OK(vaccineResponse);
    }

    @Override
    public Result delete(Long id) {
        Vaccine vaccine = this.vaccineRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.valueOf(id)));

        this.vaccineRepository.delete(vaccine);

        return ResultHelper.DELETED();
    }

    @Override
    public ResultData<VaccineResponse> update(Long id, VaccineUpdateRequest vaccineUpdateRequest) {
        Vaccine vaccine = this.vaccineRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.valueOf(id)));

        Long animalId = vaccineUpdateRequest.getAnimalId();
        Animal animal = this.animalRepository.findById(animalId)
                .orElseThrow(() -> new NotFoundException(String.valueOf(animalId)));

        int vaccineCount = this.vaccineRepository.findHasVaccine(
                vaccineUpdateRequest.getAnimalId(),
                vaccineUpdateRequest.getName(),
                vaccineUpdateRequest.getCode(),
                vaccineUpdateRequest.getProtectionStartDate(),
                vaccineUpdateRequest.getProtectionFinishDate()
        );

        if (vaccineCount > 0) {
            throw new VaccineExpiredException();
        }

        this.vaccineMapper.update(vaccine, vaccineUpdateRequest);

        vaccine.setAnimal(animal);
        Vaccine savedVaccine = this.vaccineRepository.save(vaccine);


        VaccineResponse vaccineResponse = this.vaccineMapper.asOutPut(savedVaccine);
        vaccineResponse.setAnimalId(animalId);

        return ResultHelper.OK(vaccineResponse);
    }

    @Override
    public ResultData<List<VaccineResponse>> findByFilter(Long animalId) {
        List<Vaccine> vaccineList = this.vaccineRepository.findByFilter(animalId);

        List<VaccineResponse> vaccineResponseList = this.vaccineMapper.asOutPutList(vaccineList);

        return ResultHelper.OK(vaccineResponseList);
    }

    @Override
    public ResultData<List<VaccineResponse>> filterByFinishDate(LocalDate startDate, LocalDate endDate) {
        List<Vaccine> vaccineList = this.vaccineRepository.filterByFinishDate(startDate,endDate);

        List<VaccineResponse> vaccineResponseList = this.vaccineMapper.asOutPutList(vaccineList);

        return ResultHelper.OK(vaccineResponseList);
    }


}
