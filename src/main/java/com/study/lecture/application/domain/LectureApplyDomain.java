package com.study.lecture.application.domain;

public record LectureApplyDomain(
        long id,
        long userId,
        String userName,
        long lectureId,
        String lectureName
) {
}
