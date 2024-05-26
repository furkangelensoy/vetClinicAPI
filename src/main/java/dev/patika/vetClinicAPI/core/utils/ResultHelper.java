package dev.patika.vetClinicAPI.core.utils;

import dev.patika.vetClinicAPI.core.result.Result;
import dev.patika.vetClinicAPI.core.result.ResultData;
import org.springframework.http.HttpStatus;

public class ResultHelper {
    public static <T> ResultData<T> CREATED(T data) {
        return new ResultData<>(true, Message.CREATED, HttpStatus.CREATED.value(), data);
    }

    public static <T> ResultData<T> ERROR(T data) {
        return new ResultData<>(false, Message.VALIDATE_ERROR, HttpStatus.BAD_REQUEST.value(), data);
    }

    public static <T> ResultData<T> OK(T data) {
        return new ResultData<>(true, Message.OK, HttpStatus.OK.value(), data);
    }

    public static Result DELETED() {
        return new Result(true, Message.OK, HttpStatus.NO_CONTENT.value());
    }

    public static Result NOT_FOUND(String message) {
        return new Result(false, message + Message.NOT_FOUND, HttpStatus.NOT_FOUND.value());
    }
}
