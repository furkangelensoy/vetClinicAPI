package dev.patika.vetClinicAPI.service.serviceImpl;

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
        Long doctorId = availableSaveRequest.getDoctorId();
        Doctor doctor = this.doctorRepository.findById(doctorId)
                .orElseThrow(() -> new NotFoundException(String.valueOf(doctorId)));

        AvailableDate availableDate = this.availableDateMapper.asEntity(availableSaveRequest);
        availableDate.setDoctor(doctor);

        Optional<AvailableDate> hasDate = this.availableDateRepository.findByDate(
                availableSaveRequest.getAvailableDate(),
                doctorId
        );

        if (hasDate.isPresent()){
            throw new RuntimeException();
        }

        AvailableDate savedDate = this.availableDateRepository.save(availableDate);

        AvailableResponse availableResponse = this.availableDateMapper.asOutPut(savedDate);
        availableResponse.setDoctorId(doctorId);

        return ResultHelper.CREATED(availableResponse);
    }

    @Override
    public ResultData<AvailableResponse> getById(Long id) {
        AvailableDate availableDate = this.availableDateRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.valueOf(id)));

        AvailableResponse availableResponse = this.availableDateMapper.asOutPut(availableDate);
        availableResponse.setDoctorId(availableDate.getDoctor().getId());

        return ResultHelper.OK(availableResponse);
    }

    @Override
    public Result delete(Long id) {
        AvailableDate availableDate = this.availableDateRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.valueOf(id)));

        this.availableDateRepository.delete(availableDate);

        return ResultHelper.DELETED();
    }

    @Override
    public ResultData<AvailableResponse> update(Long id, AvailableUpdateRequest availableUpdateRequest) {
        AvailableDate availableDate = this.availableDateRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.valueOf(id)));

        Long doctorId = availableUpdateRequest.getDoctorId();
        Doctor doctor = this.doctorRepository.findById(doctorId)
                .orElseThrow(() -> new NotFoundException(String.valueOf(doctorId)));


        Optional<AvailableDate> hasDate = this.availableDateRepository.findByDate(
                availableUpdateRequest.getAvailableDate(),
                doctorId
        );

        if (hasDate.isPresent()){
            throw new RuntimeException();
        }

        this.availableDateMapper.update(availableDate,availableUpdateRequest);
        availableDate.setDoctor(doctor);

        AvailableDate savedDate = this.availableDateRepository.save(availableDate);
        AvailableResponse availableResponse = this.availableDateMapper.asOutPut(savedDate);
        availableResponse.setDoctorId(doctorId);

        return ResultHelper.OK(availableResponse);
    }

    @Override
    public ResultData<List<AvailableResponse>> findAll() {
        List<AvailableDate> availableDateList = this.availableDateRepository.findAll();

        List<AvailableResponse> availableResponseList = this.availableDateMapper.asOutPutList(availableDateList);

        return ResultHelper.OK(availableResponseList);
    }
}
