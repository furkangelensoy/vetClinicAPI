package dev.patika.vetClinicAPI.service.serviceImpl;

import dev.patika.vetClinicAPI.core.exception.AlreadyRegistered;
import dev.patika.vetClinicAPI.core.exception.NotFoundException;
import dev.patika.vetClinicAPI.core.result.Result;
import dev.patika.vetClinicAPI.core.result.ResultData;
import dev.patika.vetClinicAPI.core.utils.ResultHelper;
import dev.patika.vetClinicAPI.dto.request.availableDate.AvailableSaveRequest;
import dev.patika.vetClinicAPI.dto.request.availableDate.AvailableUpdateRequest;
import dev.patika.vetClinicAPI.dto.response.availableDate.AvailableResponse;
import dev.patika.vetClinicAPI.entity.AvailableDate;
import dev.patika.vetClinicAPI.entity.Doctor;
import dev.patika.vetClinicAPI.core.config.mapper.AvailableDateMapper;
import dev.patika.vetClinicAPI.repository.AvailableDateRepository;
import dev.patika.vetClinicAPI.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AvailableDateService implements dev.patika.vetClinicAPI.service.AvailableDateService {

    private final AvailableDateRepository availableDateRepository;
    private final AvailableDateMapper availableDateMapper;
    private final DoctorRepository doctorRepository;


    @Override
    public ResultData<AvailableResponse> save(AvailableSaveRequest availableSaveRequest) {
        //This method saves an available date to the database according to the availableSaveRequest.

        //Checks doctorId. If there is no doctor with this id, it throws exception.
        Long doctorId = availableSaveRequest.getDoctorId();
        Doctor doctor = this.doctorRepository.findById(doctorId)
                .orElseThrow(() -> new NotFoundException(String.valueOf(doctorId)));

        AvailableDate availableDate = this.availableDateMapper.asEntity(availableSaveRequest);
        availableDate.setDoctor(doctor);

        //Checks if the record already exists by doctorId and date.
        Optional<AvailableDate> hasDate = this.availableDateRepository.findByDate(
                availableSaveRequest.getAvailableDate(),
                doctorId
        );

        //Throws an error if the record already exists.
        if (hasDate.isPresent()) {
            throw new AlreadyRegistered();
        }

        AvailableDate savedDate = this.availableDateRepository.save(availableDate);

        AvailableResponse availableResponse = this.availableDateMapper.asOutPut(savedDate);
        availableResponse.setDoctor(doctor);

        return ResultHelper.CREATED(availableResponse);
    }

    @Override
    public ResultData<AvailableResponse> getById(Long id) {
        //This method gets an available date from the database according to the id.

        AvailableDate availableDate = this.availableDateRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.valueOf(id)));

        AvailableResponse availableResponse = this.availableDateMapper.asOutPut(availableDate);
        availableResponse.setDoctor(availableDate.getDoctor());

        return ResultHelper.OK(availableResponse);
    }

    @Override
    public Result delete(Long id) {
        //This method deletes an available date from the database according to the id.

        AvailableDate availableDate = this.availableDateRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.valueOf(id)));

        this.availableDateRepository.delete(availableDate);

        return ResultHelper.DELETED();
    }

    @Override
    public ResultData<AvailableResponse> update(Long id, AvailableUpdateRequest availableUpdateRequest) {
        //This method updates an available date from the database according to the id and availableUpdateRequest.

        AvailableDate availableDate = this.availableDateRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.valueOf(id)));

        Long doctorId = availableUpdateRequest.getDoctorId();
        Doctor doctor = this.doctorRepository.findById(doctorId)
                .orElseThrow(() -> new NotFoundException(String.valueOf(doctorId)));


        Optional<AvailableDate> hasDate = this.availableDateRepository.findByDate(
                availableUpdateRequest.getAvailableDate(),
                doctorId
        );

        if (hasDate.isPresent()) {
            throw new AlreadyRegistered();
        }

        this.availableDateMapper.update(availableDate, availableUpdateRequest);
        availableDate.setDoctor(doctor);

        AvailableDate savedDate = this.availableDateRepository.save(availableDate);
        AvailableResponse availableResponse = this.availableDateMapper.asOutPut(savedDate);
        availableResponse.setDoctor(doctor);

        return ResultHelper.OK(availableResponse);
    }

    @Override
    public ResultData<List<AvailableResponse>> findAll() {
        //This method lists all available dates from the database.

        List<AvailableDate> availableDateList = this.availableDateRepository.findAll();

        List<AvailableResponse> availableResponseList = this.availableDateMapper.asOutPutList(availableDateList);

        for (int i = 0; i < availableDateList.size(); i++) {
            availableResponseList.get(i).setDoctor(availableDateList.get(i).getDoctor());
        }

        return ResultHelper.OK(availableResponseList);
    }
}
