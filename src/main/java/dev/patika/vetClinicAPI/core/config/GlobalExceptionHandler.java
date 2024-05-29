package dev.patika.vetClinicAPI.core.config;

import dev.patika.vetClinicAPI.core.exception.AlreadyRegistered;
import dev.patika.vetClinicAPI.core.exception.AppointmentException;
import dev.patika.vetClinicAPI.core.exception.NotFoundException;
import dev.patika.vetClinicAPI.core.exception.VaccineExpiredException;
import dev.patika.vetClinicAPI.core.result.Result;
import dev.patika.vetClinicAPI.core.utils.ResultHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationErrors(MethodArgumentNotValidException e) {

        List<String> validationErrorList = e.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage).toList();

        return new ResponseEntity<>(ResultHelper.ERROR(validationErrorList), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Result> handleNotFoundException(NotFoundException e) {
        return new ResponseEntity<>(ResultHelper.NOT_FOUND(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(VaccineExpiredException.class)
    public ResponseEntity<String> handleVaccineExpiredException(VaccineExpiredException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AppointmentException.class)
    public ResponseEntity<String> handleAppointmentException(AppointmentException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AlreadyRegistered.class)
    public ResponseEntity<String> handleAlreadyRegistered(AlreadyRegistered e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
