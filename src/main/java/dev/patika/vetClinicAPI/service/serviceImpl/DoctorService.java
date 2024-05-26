package dev.patika.vetClinicAPI.service.serviceImpl;

import dev.patika.vetClinicAPI.core.exception.NotFoundException;
import dev.patika.vetClinicAPI.core.result.Result;
import dev.patika.vetClinicAPI.core.result.ResultData;
import dev.patika.vetClinicAPI.core.utils.ResultHelper;
import dev.patika.vetClinicAPI.dto.request.doctor.DoctorSaveRequest;
import dev.patika.vetClinicAPI.dto.request.doctor.DoctorUpdateRequest;
import dev.patika.vetClinicAPI.dto.response.doctor.DoctorResponse;
import dev.patika.vetClinicAPI.entity.Doctor;
import dev.patika.vetClinicAPI.core.config.mapper.DoctorMapper;
import dev.patika.vetClinicAPI.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService implements dev.patika.vetClinicAPI.service.DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    @Override
    public ResultData<DoctorResponse> save(DoctorSaveRequest doctorSaveRequest) {
        Doctor savedDoctor = this.doctorRepository.save(this.doctorMapper.asEntity(doctorSaveRequest));
        DoctorResponse doctorResponse = this.doctorMapper.asOutPut(savedDoctor);

        return ResultHelper.CREATED(doctorResponse);
    }

    @Override
    public ResultData<DoctorResponse> getById(Long id) {
        Doctor doctor = this.doctorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.valueOf(id)));

        DoctorResponse doctorResponse = this.doctorMapper.asOutPut(doctor);

        return ResultHelper.OK(doctorResponse);
    }

    @Override
    public Result delete(Long id) {
        Doctor doctor = this.doctorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.valueOf(id)));

        this.doctorRepository.delete(doctor);

        return ResultHelper.DELETED();
    }

    @Override
    public ResultData<DoctorResponse> update(Long id, DoctorUpdateRequest doctorUpdateRequest) {
        Doctor doctor = this.doctorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.valueOf(id)));

        this.doctorMapper.update(doctor,doctorUpdateRequest);

        Doctor savedDoctor = this.doctorRepository.save(doctor);

        DoctorResponse doctorResponse = this.doctorMapper.asOutPut(savedDoctor);

        return ResultHelper.OK(doctorResponse);
    }

    @Override
    public ResultData<List<DoctorResponse>> findAll() {
        List<Doctor> doctorList = this.doctorRepository.findAll();

        List<DoctorResponse> doctorResponseList = this.doctorMapper.asOutPutList(doctorList);

        return ResultHelper.OK(doctorResponseList);
    }
}
