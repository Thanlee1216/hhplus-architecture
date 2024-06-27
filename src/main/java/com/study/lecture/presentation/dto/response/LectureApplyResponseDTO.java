package com.study.lecture.presentation.dto.response;

import com.study.lecture.application.domain.LectureApplyDomain;

public record LectureApplyResponseDTO(
        long userId,
        String userName,
        long lectureId,
        String lectureName
) {
    public static LectureApplyResponseDTO of(LectureApplyDomain lectureApplyDomain) {
        return new LectureApplyResponseDTO(lectureApplyDomain.userId(), lectureApplyDomain.userName(), lectureApplyDomain.lectureId(), lectureApplyDomain.lectureName());
    }
}
