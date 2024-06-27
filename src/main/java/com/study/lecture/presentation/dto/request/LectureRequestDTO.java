package com.study.lecture.presentation.dto.request;

import com.study.lecture.application.domain.LectureDomain;

public record LectureRequestDTO(
        long userId,
        String userName,
        long lectureId,
        String lectureName
) {
    public LectureDomain convertToLectureDomain() {
        return new LectureDomain(this.userId, this.userName, this.lectureId, this.lectureName);
    }
}
