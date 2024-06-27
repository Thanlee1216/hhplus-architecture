package com.study.lecture.infrastructure.exception;

import java.util.Arrays;

public enum ExceptionType {
    ApplyFail("접수가 마감된 강의입니다.")
    , Exception("에러가 발생했습니다.")
    ;

    private final String message;

    ExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static String getMessage(String exceptionType) {
        return Arrays.stream(ExceptionType.values())
                .filter(data -> data.name().equals(exceptionType))
                .findAny()
                .orElse(Exception)
                .getMessage();
    }
}
