package com.study.lecture.application.service;

import com.study.lecture.application.domain.LectureApplyDomain;
import com.study.lecture.application.domain.LectureDomain;
import com.study.lecture.application.domain.UserDomain;

import java.util.List;

public interface LectureService {
    LectureApplyDomain lectureApply(UserDomain user, LectureDomain lecture);
    List<LectureDomain> getLectureList();
    List<LectureDomain> getLectureApply(UserDomain user);
}
