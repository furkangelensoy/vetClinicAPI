package dev.patika.vetClinicAPI.service.serviceImpl;

import dev.patika.vetClinicAPI.core.exception.NotFoundException;
import dev.patika.vetClinicAPI.core.result.Result;
import dev.patika.vetClinicAPI.core.result.ResultData;
import dev.patika.vetClinicAPI.core.utils.ResultHelper;
import dev.patika.vetClinicAPI.dto.request.appointmentDate.AppointmentSaveRequest;
import dev.patika.vetClinicAPI.dto.request.appointmentDate.AppointmentUpdateRequest;
import dev.patika.vetClinicAPI.dto.response.appointmentDate.AppointmentResponse;
import dev.patika.vetClinicAPI.entity.Animal;
import dev.patika.vetClinicAPI.entity.Appointment;
import dev.patika.vetClinicAPI.entity.AvailableDate;
import dev.patika.vetClinicAPI.entity.Doctor;
import dev.patika.vetClinicAPI.core.config.mapper.AppointmentDateMapper;
import dev.patika.vetClinicAPI.repository.AnimalRepository;
import dev.patika.vetClinicAPI.repository.AppointmentRepository;
import dev.patika.vetClinicAPI.repository.AvailableDateRepository;
import dev.patika.vetClinicAPI.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AppointmentService implements dev.patika.vetClinicAPI.service.AppointmentService {

    private final AppointmentDateMapper appointmentDateMapper;
    private final AppointmentRepository appointmentRepository;
    private final AnimalRepository animalRepository;
    private final DoctorRepository doctorRepository;
    private final AvailableDateRepository availableDateRepository;

    @Override
    public ResultData<AppointmentResponse> save(AppointmentSaveRequest appointmentSaveRequest) {
        Long animalId = appointmentSaveRequest.getAnimalId();
        Animal animal = this.animalRepository.findById(animalId)
                .orElseThrow(() -> new NotFoundException(String.valueOf(animalId)));

        Long doctorId = appointmentSaveRequest.getDoctorId();
        Doctor doctor = this.doctorRepository.findById(doctorId)
                .orElseThrow(() -> new NotFoundException(String.valueOf(doctorId)));


        Optional<AvailableDate> date = this.availableDateRepository.findByDate(
                appointmentSaveRequest.getAppointmentDate().toLocalDate(),
                doctorId
        );

        if (date.isEmpty()) {
            return null;
        }

        int hour = appointmentSaveRequest.getAppointmentDate().getHour();
        int minute = appointmentSaveRequest.getAppointmentDate().getMinute();

        if (hour < 8 || hour > 17 || minute != 0) {
            return null;
        }

        Optional<Appointment> appointmentOptional = this.appointmentRepository
                .findByDate(appointmentSaveRequest.getAppointmentDate(), doctorId);

        if (appointmentOptional.isPresent()) {
            return null;
        }


        Appointment appointment = this.appointmentDateMapper.asEntity(appointmentSaveRequest);
        appointment.setDoctor(doctor);
        appointment.setAnimal(animal);

        Appointment savedAppointment = this.appointmentRepository.save(appointment);

        AppointmentResponse appointmentResponse = this.appointmentDateMapper.asOutPut(savedAppointment);
        appointmentResponse.setAnimal(animal);
        appointmentResponse.setDoctor(doctor);

        return ResultHelper.CREATED(appointmentResponse);
    }

    @Override
    public ResultData<AppointmentResponse> getById(Long id) {
        Appointment appointment = this.appointmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.valueOf(id)));

        AppointmentResponse appointmentResponse = this.appointmentDateMapper.asOutPut(appointment);
        appointmentResponse.setDoctor(appointment.getDoctor());
        appointmentResponse.setAnimal(appointment.getAnimal());

        return ResultHelper.OK(appointmentResponse);
    }

    @Override
    public Result delete(Long id) {
        Appointment appointment = this.appointmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.valueOf(id)));

        this.appointmentRepository.delete(appointment);

        return ResultHelper.DELETED();
    }

    @Override
    public ResultData<AppointmentResponse> update(Long id, AppointmentUpdateRequest appointmentUpdateRequest) {
        Appointment appointment = this.appointmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.valueOf(id)));

        Long animalId = appointmentUpdateRequest.getAnimalId();
        Animal animal = this.animalRepository.findById(animalId)
                .orElseThrow(() -> new NotFoundException(String.valueOf(animalId)));

        Long doctorId = appointmentUpdateRequest.getDoctorId();
        Doctor doctor = this.doctorRepository.findById(doctorId)
                .orElseThrow(() -> new NotFoundException(String.valueOf(doctorId)));


        this.appointmentDateMapper.update(appointment, appointmentUpdateRequest);
        appointment.setAnimal(animal);
        appointment.setDoctor(doctor);
        Appointment updatedAppointment = this.appointmentRepository.save(appointment);

        AppointmentResponse appointmentResponse = this.appointmentDateMapper.asOutPut(updatedAppointment);
        appointmentResponse.setAnimal(animal);
        appointmentResponse.setDoctor(doctor);

        return ResultHelper.OK(appointmentResponse);
    }

    @Override
    public ResultData<List<AppointmentResponse>> findAll() {
        List<Appointment> appointmentList = this.appointmentRepository.findAll();

        List<AppointmentResponse> appointmentResponseList = this.appointmentDateMapper.asOutPutList(appointmentList);

        return ResultHelper.OK(appointmentResponseList);
    }

    @Override
    public ResultData<List<AppointmentResponse>> findByDateRangeAndAnimalId(
            LocalDate startDate, LocalDate endDate, Long animalId) {


        List<Appointment> appointmentList = this.appointmentRepository
                .findByDateRangeAndAnimalId(startDate, endDate, animalId);


        List<AppointmentResponse> appointmentResponseList = this.appointmentDateMapper.asOutPutList(appointmentList);

        for (int i = 0; i < appointmentList.size(); i++) {
            appointmentResponseList.get(i).setDoctor(appointmentList.get(i).getDoctor());
        }

        return ResultHelper.OK(appointmentResponseList);
    }

    @Override
    public ResultData<List<AppointmentResponse>> findByDateRangeAndDoctorId(
            LocalDate startDate, LocalDate endDate, Long doctorId) {

        List<Appointment> appointmentList = this.appointmentRepository
                .findByDateRangeAndDoctorId(startDate, endDate, doctorId);


        List<AppointmentResponse> appointmentResponseList = this.appointmentDateMapper.asOutPutList(appointmentList);


        return ResultHelper.OK(appointmentResponseList);
    }
}
