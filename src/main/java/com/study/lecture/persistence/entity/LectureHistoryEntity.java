package com.study.lecture.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "lecture_history")
@Data
public class LectureHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private long userId;

    @Column(nullable = false)
    private long lectureId;

    @Column(nullable = false)
    private boolean isApply;

}
