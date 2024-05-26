package dev.patika.vetClinicAPI.core.exception;

public class VaccineExpiredException extends RuntimeException {
    public VaccineExpiredException() {
        super("The protection period of this vaccine has not yet expired");
    }
}
