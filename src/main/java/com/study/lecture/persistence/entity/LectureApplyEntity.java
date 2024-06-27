package com.study.lecture.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "lecture_apply")
@Data
public class LectureApplyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private long userId;

    @Column(nullable = false)
    private long lectureId;
}
