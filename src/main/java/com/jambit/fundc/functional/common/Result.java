package com.jambit.fundc.functional.common;

public class Result<T> {
    private final T value;

    private final ResultCode resultCode;

    Result(final T value, final ResultCode resultCode) {
        this.value = value;
        this.resultCode = resultCode;
    }

    public static <T> Result<T> forSuccess(final T value) {
        return new Result<>(value, ResultCode.SUCCESS);
    }

    public static <T> Result<T> forFailute(final ResultCode code) {
        return new Result<>(null, code);
    }
}
