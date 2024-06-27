package com.study.lecture.application.domain;

public record LectureDomain(
        long userId,
        String userName,
        long lectureId,
        String lectureName
) {
}
