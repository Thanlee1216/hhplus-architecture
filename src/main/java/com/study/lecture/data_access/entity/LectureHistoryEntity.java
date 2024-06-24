package com.study.lecture.data_access.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "lecture_history")
@Data
public class LectureHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long lectureId;

}
