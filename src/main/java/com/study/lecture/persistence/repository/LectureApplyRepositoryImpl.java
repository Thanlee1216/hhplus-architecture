package com.study.lecture.persistence.repository;

import com.study.lecture.application.Repository.LectureApplyRepository;
import com.study.lecture.application.domain.LectureApplyDomain;
import com.study.lecture.application.domain.LectureDomain;
import com.study.lecture.application.domain.UserDomain;
import com.study.lecture.persistence.entity.LectureApplyEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class LectureApplyRepositoryImpl implements LectureApplyRepository {

    private final LectureApplyJpaRepository lectureApplyJpaRepository;

    @Override
    public LectureApplyDomain insert(UserDomain user, LectureDomain lecture) {
        LectureApplyEntity lectureApplyEntity = lectureApplyJpaRepository.save(new LectureApplyEntity(user, lecture));
        return lectureApplyEntity.convertToLectureApplyDomain();
    }

    @Override
    public List<LectureDomain> findByUserId(UserDomain user) {
        List<LectureApplyEntity> lectureApplyEntity = lectureApplyJpaRepository.findByUserId(user.userId());
        return LectureApplyEntity.convertToLectureDomain(lectureApplyEntity);
    }
}
