package com.study.lecture.persistence.repository;

import com.study.lecture.persistence.entity.LectureHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureHistoryRepository extends JpaRepository<LectureHistoryEntity, Long> {
}
