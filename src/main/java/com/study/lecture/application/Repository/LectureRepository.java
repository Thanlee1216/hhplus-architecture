package com.study.lecture.application.Repository;

import com.study.lecture.application.domain.LectureDomain;

import java.util.List;

public interface LectureRepository {
    LectureDomain findById(LectureDomain lecture);

    List<LectureDomain> findAll();
}
