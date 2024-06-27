package com.study.lecture.application.domain;

public record LectureDomain(
        long lectureId,
        String lectureName,
        String date
) {
}
