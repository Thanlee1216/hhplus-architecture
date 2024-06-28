package com.study.lecture.persistence.entity;

import com.study.lecture.application.domain.LectureDomain;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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

    @Column(nullable = false)
    private long applicantCount;

    public LectureEntity(LectureDomain lecture) {
        this.name = lecture.lectureName();
        this.date = lecture.date();
        this.applicantCount = lecture.applicantCount();
    }

    public LectureDomain convertToLectureDomain() {
        return new LectureDomain(id, name, date, applicantCount);
    }

    public static List<LectureDomain> convertToLectureDomain(List<LectureEntity> lectureEntityList) {
        return lectureEntityList.stream()
                .map(lectureEntity -> new LectureDomain(
                        lectureEntity.getId(),
                        lectureEntity.getName(),
                        lectureEntity.getDate(),
                        lectureEntity.getApplicantCount()
                ))
                .toList();
    }
}
