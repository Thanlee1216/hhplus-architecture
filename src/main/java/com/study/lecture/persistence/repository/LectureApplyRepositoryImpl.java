package com.study.lecture.persistence.repository;

import com.study.lecture.application.Repository.LectureApplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class LectureApplyRepositoryImpl implements LectureApplyRepository {

    private final LectureApplyJpaRepository lectureApplyJpaRepository;

}
