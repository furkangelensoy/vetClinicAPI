package dev.patika.vetClinicAPI.core.exception;

public class AlreadyRegistered extends RuntimeException {
    public AlreadyRegistered() {
        super("Registration already exists");
    }
}
