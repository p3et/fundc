package com.jambit.fundc.functional.common;

import java.util.Optional;

public class Result<T> {

    private final T value;

    private final ResultCode resultCode;

    private Result(final T value, final ResultCode resultCode) {
        this.value = value;
        this.resultCode = resultCode;
    }

    public static <T> Result<T> onSuccess(final T value) {
        return new Result<>(value, ResultCode.SUCCESS);
    }

    public static <T> Result<T> onError(final ResultCode code) {
        return new Result<>(null, code);
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public Optional<T> getValue() {
        return Optional.ofNullable(value);
    }
}
