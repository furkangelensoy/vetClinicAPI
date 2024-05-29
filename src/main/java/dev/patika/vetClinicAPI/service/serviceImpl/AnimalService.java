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
        //This method saves an animal to the database according to the animalSaveRequest.

        //Checks customerId. If there is no customer with this id, it throws exception.
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
        //This method gets an animal from the database according to the id.

        Animal foundAnimal = this.animalRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.valueOf(id)));

        AnimalResponse animalResponse = this.animalMapper.asOutPut(foundAnimal);
        animalResponse.setCustomer(foundAnimal.getCustomer());

        return ResultHelper.OK(animalResponse);
    }

    @Override
    public Result delete(Long id) {
        //This method deletes an animal from the database according to the id.

        Animal animal = this.animalRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.valueOf(id)));

        this.animalRepository.delete(animal);

        return ResultHelper.DELETED();
    }

    @Override
    public ResultData<AnimalResponse> update(Long id, AnimalUpdateRequest animalUpdateRequest) {
        //This method updates an animal from the database according to the id and AnimalUpdateRequest.

        //Checks id. If there is no animal with this id, it throws exception.
        Animal animal = this.animalRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.valueOf(id)));

        //Checks customerId. If there is no customer with this id, it throws exception.
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
        //This method lists animals from the database according to the customerId and animalName.
        //If no parameters are entered, it lists all animals.


        List<Animal> animalList = this.animalRepository.findByFilter(customerId, animalName);
        List<AnimalResponse> animalResponseList = this.animalMapper.asOutPutList(animalList);

        for (int i = 0; i < animalList.size(); i++) {
            animalResponseList.get(i).setCustomer(animalList.get(i).getCustomer());
        }

        return ResultHelper.OK(animalResponseList);
    }

}
