package com.study.lecture.presentation.dto.request;

import com.study.lecture.application.domain.LectureDomain;
import com.study.lecture.application.domain.UserDomain;

public record LectureApplyRequestDTO(
        long userId,
        String userName,
        long lectureId,
        String lectureName,
        String lectureDate
) {
    public UserDomain convertToUserDomain() {
        return new UserDomain(this.userId, this.userName);
    }

    public LectureDomain convertToLectureDomain() {
        return new LectureDomain(this.lectureId, this.lectureName, this.lectureDate);
    }
}
