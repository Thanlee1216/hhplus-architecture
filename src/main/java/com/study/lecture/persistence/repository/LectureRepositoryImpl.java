package com.study.lecture.persistence.repository;

import com.study.lecture.application.Repository.LectureRepository;
import com.study.lecture.application.domain.LectureDomain;
import com.study.lecture.persistence.entity.LectureEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class LectureRepositoryImpl implements LectureRepository {

    private final LectureJpaRepository lectureJpaRepository;

    @Override
    public LectureDomain findById(LectureDomain lecture) {
        LectureEntity entity = lectureJpaRepository.findById(lecture.lectureId()).get();
        return entity.convertToLectureDomain();
    }

    @Override
    public List<LectureDomain> findAll() {
        List<LectureEntity> lectureEntityList = lectureJpaRepository.findAll();
        return LectureEntity.convertToLectureDomain(lectureEntityList);
    }
}
