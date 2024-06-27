package com.study.lecture.persistence.entity;

import com.study.lecture.application.domain.LectureApplyDomain;
import com.study.lecture.application.domain.LectureDomain;
import com.study.lecture.application.domain.UserDomain;
import com.study.lecture.presentation.dto.response.LectureResponseDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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
    private String userName;

    @Column(nullable = false)
    private long lectureId;

    @Column(nullable = false)
    private String lectureName;

    public LectureApplyEntity() {
    }

    public LectureApplyEntity(UserDomain user, LectureDomain lecture) {
        this.userId = user.userId();
        this.userName = user.userName();
        this.lectureId = lecture.lectureId();
        this.lectureName = lecture.lectureName();
    }


    public LectureApplyDomain convertToLectureApplyDomain() {
        return new LectureApplyDomain(id, userId, userName, lectureId, lectureName);
    }


    public static List<LectureDomain> convertToLectureDomain(List<LectureApplyEntity> lectureApplyEntityList) {
        return lectureApplyEntityList.stream()
                .map(lectureApplyEntity -> new LectureDomain(
                        lectureApplyEntity.getLectureId(),
                        lectureApplyEntity.getLectureName(),
                        null, 0
                ))
                .toList();
    }
}
