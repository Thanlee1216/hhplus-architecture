package com.study.lecture.application.service;

import com.study.lecture.application.domain.LectureApplyDomain;
import com.study.lecture.application.domain.LectureDomain;
import com.study.lecture.application.domain.UserDomain;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureServiceImpl implements LectureService {
    @Override
    public LectureApplyDomain lectureApply(UserDomain user, LectureDomain lecture) {
        return null;
    }

    @Override
    public List<LectureDomain> getLectureList() {
        return List.of();
    }

    @Override
    public List<LectureDomain> getLectureApply(UserDomain user) {
        return List.of();
    }
}
