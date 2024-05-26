package dev.patika.vetClinicAPI.service.serviceImpl;

import dev.patika.vetClinicAPI.entity.Customer;
import dev.patika.vetClinicAPI.core.config.mapper.AnimalMapper;
import dev.patika.vetClinicAPI.core.exception.NotFoundException;
import dev.patika.vetClinicAPI.core.result.Result;
import dev.patika.vetClinicAPI.core.result.ResultData;
import dev.patika.vetClinicAPI.core.utils.ResultHelper;
import dev.patika.vetClinicAPI.dto.request.animal.AnimalSaveRequest;
import dev.patika.vetClinicAPI.dto.request.animal.AnimalUpdateRequest;
import dev.patika.vetClinicAPI.dto.response.animal.AnimalResponse;
import dev.patika.vetClinicAPI.entity.Animal;
import dev.patika.vetClinicAPI.repository.AnimalRepository;
import dev.patika.vetClinicAPI.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalService implements dev.patika.vetClinicAPI.service.AnimalService {

    private final AnimalRepository animalRepository;
    private final AnimalMapper animalMapper;
    private final CustomerRepository customerRepository;


    @Override
    public ResultData<AnimalResponse> save(AnimalSaveRequest animalSaveRequest) {
        Long customerId = animalSaveRequest.getCustomerId();
        Customer customer = this.customerRepository.findById(
                customerId).orElseThrow(() -> new NotFoundException(String.valueOf(customerId)));


        Animal saveAnimal = this.animalMapper.asEntity(animalSaveRequest);
        saveAnimal.setCustomer(customer);


        AnimalResponse animalResponse = this.animalMapper
                .asOutPut(this.animalRepository.save(saveAnimal));

        animalResponse.setCustomer(customer);

        return ResultHelper.CREATED(animalResponse);
    }

    @Override
    public ResultData<AnimalResponse> getById(Long id) {
        Animal foundAnimal = this.animalRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.valueOf(id)));

        AnimalResponse animalResponse = this.animalMapper.asOutPut(foundAnimal);
        animalResponse.setCustomer(foundAnimal.getCustomer());

        return ResultHelper.OK(animalResponse);
    }

    @Override
    public Result delete(Long id) {
        Animal animal = this.animalRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.valueOf(id)));

        this.animalRepository.delete(animal);

        return ResultHelper.DELETED();
    }

    @Override
    public ResultData<AnimalResponse> update(Long id, AnimalUpdateRequest animalUpdateRequest) {
        Animal animal = this.animalRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.valueOf(id)));

        Customer customer = this.customerRepository.findById(animalUpdateRequest.getCustomerId())
                .orElseThrow(() -> new NotFoundException(String.valueOf(id)));


        this.animalMapper.update(animal, animalUpdateRequest);
        animal.setCustomer(customer);

        Animal savedAnimal = this.animalRepository.save(animal);
        AnimalResponse animalResponse = this.animalMapper.asOutPut(savedAnimal);
        animalResponse.setCustomer(savedAnimal.getCustomer());

        return ResultHelper.OK(animalResponse);
    }

    @Override
    public ResultData<List<AnimalResponse>> findAll(Long customerId, String animalName) {
        List<Animal> animalList = this.animalRepository.findByFilter(customerId, animalName);
        List<AnimalResponse> animalResponseList = this.animalMapper.asOutPutList(animalList);

        return ResultHelper.OK(animalResponseList);
    }

}
