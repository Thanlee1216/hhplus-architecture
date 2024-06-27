package com.study.lecture.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "lecture")
@Data
public class LectureEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 8)
    private String date;
}
