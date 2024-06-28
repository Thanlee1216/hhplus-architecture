package com.study.lecture.application.domain;

import com.study.lecture.infrastructure.exception.ApplyOverflowException;

public record LectureDomain(
        long lectureId,
        String lectureName,
        String date,
        long applicantCount
) {
    public LectureDomain vaildateApplicantConutOverflow() {
        if(applicantCount >= 30) {
            throw new ApplyOverflowException("ApplyFail");
        }
        return this;
    }

    public LectureDomain countUpdate() {
        return new LectureDomain(lectureId, lectureName, date, applicantCount + 1L);
    }
}
