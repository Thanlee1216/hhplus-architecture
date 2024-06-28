package com.study.lecture.persistence.repository;

import com.study.lecture.persistence.entity.LectureApplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LectureApplyJpaRepository extends JpaRepository<LectureApplyEntity, Long> {
    List<LectureApplyEntity> findByUserId(long userId);
}
