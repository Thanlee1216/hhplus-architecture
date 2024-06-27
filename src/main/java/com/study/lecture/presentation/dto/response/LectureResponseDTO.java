package com.study.lecture.presentation.dto.response;

import com.study.lecture.application.domain.LectureDomain;

import java.util.List;

public record LectureResponseDTO(
        long lectureId,
        String lectureName,
        String date
) {
    public static List<LectureResponseDTO> converteFromLectureDomainToDtoList(List<LectureDomain> lectureDomainList) {
        return lectureDomainList.stream()
                .map(lectureDomain -> new LectureResponseDTO(
                        lectureDomain.lectureId(),
                        lectureDomain.lectureName(),
                        lectureDomain.date()
                ))
                .toList();
    }
}
