package com.study.lecture.infrastructure.exception;

public record ErrorResponse(
        String code,
        String message
) {
}
