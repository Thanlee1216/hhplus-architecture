package com.study.lecture.infrastructure.exception;

public class ApplyOverflowException extends RuntimeException {

    String code;

    public ApplyOverflowException(String code) {
        this.code = code;
    }
    public String getCode() {
        return this.code;
    }
}
