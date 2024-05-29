package dev.patika.vetClinicAPI.service.serviceImpl;

import dev.patika.vetClinicAPI.core.exception.AppointmentException;
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
        //This method saves an appointment to the database according to the appointmentSaveRequest.

        //Checks animalId. If there is no animal with this id, it throws exception.
        Long animalId = appointmentSaveRequest.getAnimalId();
        Animal animal = this.animalRepository.findById(animalId)
                .orElseThrow(() -> new NotFoundException(String.valueOf(animalId)));

        //Checks doctorId. If there is no doctor with this id, it throws exception.
        Long doctorId = appointmentSaveRequest.getDoctorId();
        Doctor doctor = this.doctorRepository.findById(doctorId)
                .orElseThrow(() -> new NotFoundException(String.valueOf(doctorId)));


        //It checks whether the doctor is working that day according to the entered date and doctor.
        Optional<AvailableDate> date = this.availableDateRepository.findByDate(
                appointmentSaveRequest.getAppointmentDate().toLocalDate(),
                doctorId
        );

        if (date.isEmpty()) {
            throw new AppointmentException("Appointment could not be created. " +
                    "The doctor is not working on this date");
        }

        int hour = appointmentSaveRequest.getAppointmentDate().getHour();
        int minute = appointmentSaveRequest.getAppointmentDate().getMinute();

        if (hour < 8 || hour > 17 || minute != 0) {
            throw new AppointmentException("Appointment could not be created." +
                    "Doctors work between 08:00 and 18:00." +
                    " Appointments can be made between these hours with a minute value of 0. Try again.");
        }

        //Checks whether there is an appointment based on the entered date and doctorId.
        Optional<Appointment> appointmentOptional = this.appointmentRepository
                .findByDate(appointmentSaveRequest.getAppointmentDate(), doctorId);

        if (appointmentOptional.isPresent()) {
            throw new AppointmentException("Appointment could not be created." +
                    "Another appointment is available at the entered time. Enter another time or date.");
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
        //This method gets an appointment from the database according to the id.

        Appointment appointment = this.appointmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.valueOf(id)));

        AppointmentResponse appointmentResponse = this.appointmentDateMapper.asOutPut(appointment);
        appointmentResponse.setDoctor(appointment.getDoctor());
        appointmentResponse.setAnimal(appointment.getAnimal());

        return ResultHelper.OK(appointmentResponse);
    }

    @Override
    public Result delete(Long id) {
        //This method deletes an appointment from the database according to the id.

        Appointment appointment = this.appointmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.valueOf(id)));

        this.appointmentRepository.delete(appointment);

        return ResultHelper.DELETED();
    }

    @Override
    public ResultData<AppointmentResponse> update(Long id, AppointmentUpdateRequest appointmentUpdateRequest) {
        //This method saves an appointment to the database according to the id and appointmentSaveRequest.

        //Checks id. If there is no appointment with this id, it throws exception.
        Appointment appointment = this.appointmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.valueOf(id)));

        //Checks animalId from appointmentUpdateRequest. If there is no animal with this id, it throws exception.
        Long animalId = appointmentUpdateRequest.getAnimalId();
        Animal animal = this.animalRepository.findById(animalId)
                .orElseThrow(() -> new NotFoundException(String.valueOf(animalId)));

        //Checks doctorId from appointmentUpdateRequest. If there is no doctor with this id, it throws exception.
        Long doctorId = appointmentUpdateRequest.getDoctorId();
        Doctor doctor = this.doctorRepository.findById(doctorId)
                .orElseThrow(() -> new NotFoundException(String.valueOf(doctorId)));


        //It checks whether the doctor is working that day according to the entered date and doctor.
        Optional<AvailableDate> date = this.availableDateRepository.findByDate(
                appointmentUpdateRequest.getAppointmentDate().toLocalDate(),
                doctorId
        );

        if (date.isEmpty()) {
            throw new AppointmentException("Appointment could not be created. " +
                    "The doctor is not working on this date");
        }

        int hour = appointmentUpdateRequest.getAppointmentDate().getHour();
        int minute = appointmentUpdateRequest.getAppointmentDate().getMinute();

        if (hour < 8 || hour > 17 || minute != 0) {
            throw new AppointmentException("Appointment could not be created." +
                    "Doctors work between 08:00 and 18:00." +
                    " Appointments can be made between these hours with a minute value of 0. Try again.");
        }

        //Checks whether there is an appointment based on the entered date and doctorId.
        Optional<Appointment> appointmentOptional = this.appointmentRepository
                .findByDate(appointmentUpdateRequest.getAppointmentDate(), doctorId);

        if (appointmentOptional.isPresent()) {
            throw new AppointmentException("Appointment could not be created." +
                    "Another appointment is available at the entered time. Enter another time or date.");
        }

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
        //This method lists all appointments from the database.

        List<Appointment> appointmentList = this.appointmentRepository.findAll();

        List<AppointmentResponse> appointmentResponseList = this.appointmentDateMapper.asOutPutList(appointmentList);

        for (int i = 0; i < appointmentResponseList.size(); i++) {
            appointmentResponseList.get(i).setDoctor(appointmentList.get(i).getDoctor());
            appointmentResponseList.get(i).setAnimal(appointmentList.get(i).getAnimal());
        }

        return ResultHelper.OK(appointmentResponseList);
    }

    @Override
    public ResultData<List<AppointmentResponse>> findByDateRangeAndAnimalId(
            LocalDate startDate, LocalDate endDate, Long animalId) {

        //This method lists appointments from the database according to startDate, endDate and animalId.

        List<Appointment> appointmentList = this.appointmentRepository
                .findByDateRangeAndAnimalId(startDate, endDate, animalId);


        List<AppointmentResponse> appointmentResponseList = this.appointmentDateMapper.asOutPutList(appointmentList);

        for (int i = 0; i < appointmentResponseList.size(); i++) {
            appointmentResponseList.get(i).setDoctor(appointmentList.get(i).getDoctor());
            appointmentResponseList.get(i).setAnimal(appointmentList.get(i).getAnimal());
        }

        return ResultHelper.OK(appointmentResponseList);
    }

    @Override
    public ResultData<List<AppointmentResponse>> findByDateRangeAndDoctorId(
            LocalDate startDate, LocalDate endDate, Long doctorId) {

        //This method lists appointments from the database according to startDate, endDate and doctorId.

        List<Appointment> appointmentList = this.appointmentRepository
                .findByDateRangeAndDoctorId(startDate, endDate, doctorId);


        List<AppointmentResponse> appointmentResponseList = this.appointmentDateMapper.asOutPutList(appointmentList);

        for (int i = 0; i < appointmentResponseList.size(); i++) {
            appointmentResponseList.get(i).setDoctor(appointmentList.get(i).getDoctor());
            appointmentResponseList.get(i).setAnimal(appointmentList.get(i).getAnimal());
        }

        return ResultHelper.OK(appointmentResponseList);
    }
}
