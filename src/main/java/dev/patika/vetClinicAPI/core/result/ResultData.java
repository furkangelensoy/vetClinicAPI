package dev.patika.vetClinicAPI.core.result;

import lombok.Getter;

@Getter
public class ResultData<T> extends Result {

    private final T data;

    public ResultData(boolean status, String message, int httpStatus, T data) {
        super(status, message, httpStatus);
        this.data = data;
    }
}
