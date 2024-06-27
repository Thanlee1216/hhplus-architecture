package com.study.lecture.application.Repository;

import com.study.lecture.application.domain.LectureDomain;
import com.study.lecture.application.domain.LectureHistoryDomain;
import com.study.lecture.application.domain.UserDomain;

public interface LectureHistoryRepository {
    LectureHistoryDomain insert(UserDomain user, LectureDomain lecture);
}
