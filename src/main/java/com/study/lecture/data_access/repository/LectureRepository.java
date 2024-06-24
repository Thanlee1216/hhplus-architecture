package com.study.lecture.data_access.repository;

import com.study.lecture.data_access.entity.LectureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<LectureEntity, Long> {
}
