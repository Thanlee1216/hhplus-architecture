package com.study.lecture.application.Repository;

import com.study.lecture.application.domain.LectureApplyDomain;
import com.study.lecture.application.domain.LectureDomain;
import com.study.lecture.application.domain.UserDomain;

import java.util.List;

public interface LectureApplyRepository {
    LectureApplyDomain insert(UserDomain user, LectureDomain lecture);

    List<LectureDomain> findByUserId(UserDomain user);
}
