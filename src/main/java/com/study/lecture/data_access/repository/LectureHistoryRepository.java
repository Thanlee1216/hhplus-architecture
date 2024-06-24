package com.study.lecture.data_access.repository;

import com.study.lecture.data_access.entity.LectureHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureHistoryRepository extends JpaRepository<LectureHistoryEntity, Long> {
}
