package com.study.lecture.persistence.repository;

import com.study.lecture.application.domain.LectureDomain;
import com.study.lecture.persistence.entity.LectureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LectureJpaRepository extends JpaRepository<LectureEntity, Long> {
}
