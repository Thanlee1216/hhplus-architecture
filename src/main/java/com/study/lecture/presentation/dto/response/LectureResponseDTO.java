package com.study.lecture.presentation.dto.response;

public record LectureResponseDTO(
        long userId,
        String userName,
        long lectureId,
        String lectureName,
        boolean isApply
) {
}
