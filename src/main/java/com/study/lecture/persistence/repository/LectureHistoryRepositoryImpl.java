package com.study.lecture.persistence.repository;

import com.study.lecture.application.Repository.LectureHistoryRepository;
import com.study.lecture.application.domain.LectureDomain;
import com.study.lecture.application.domain.LectureHistoryDomain;
import com.study.lecture.application.domain.UserDomain;
import com.study.lecture.persistence.entity.LectureApplyEntity;
import com.study.lecture.persistence.entity.LectureHistoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class LectureHistoryRepositoryImpl implements LectureHistoryRepository {

    private final LectureHistoryJpaRepository lectureHistoryJpaRepository;

    @Override
    public LectureHistoryDomain insert(UserDomain user, LectureDomain lecture) {
        LectureHistoryEntity lectureHistoryEntity = lectureHistoryJpaRepository.save(new LectureHistoryEntity(user, lecture));
        return lectureHistoryEntity.convertToLectureHistoryDomain();
    }
}
