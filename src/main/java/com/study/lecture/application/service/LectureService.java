package com.study.lecture.application.service;

import com.study.lecture.application.domain.LectureApplyDomain;
import com.study.lecture.application.domain.LectureDomain;
import com.study.lecture.application.domain.UserDomain;

public interface LectureService {
    LectureApplyDomain lectureApply(UserDomain user, LectureDomain lecture);
}
