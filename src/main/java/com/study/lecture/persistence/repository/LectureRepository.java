package com.study.lecture.persistence.repository;

import com.study.lecture.persistence.entity.LectureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<LectureEntity, Long> {
}
