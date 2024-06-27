package com.study.lecture.persistence.entity;

import com.study.lecture.application.domain.LectureApplyDomain;
import com.study.lecture.application.domain.LectureDomain;
import com.study.lecture.application.domain.LectureHistoryDomain;
import com.study.lecture.application.domain.UserDomain;
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
    
    public LectureHistoryEntity() {
    }
    
    public LectureHistoryEntity(UserDomain user, LectureDomain lecture) {
        this.userId = user.userId();
        this.lectureId = lecture.lectureId();
    }

    public LectureHistoryDomain convertToLectureHistoryDomain() {
        return new LectureHistoryDomain(userId, lectureId);
    }
}
