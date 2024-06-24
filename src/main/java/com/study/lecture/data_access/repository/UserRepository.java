package com.study.lecture.data_access.repository;

import com.study.lecture.data_access.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
