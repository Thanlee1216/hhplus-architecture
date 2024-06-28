package com.study.lecture.application.service;

import com.study.lecture.application.Repository.LectureApplyRepository;
import com.study.lecture.application.Repository.LectureHistoryRepository;
import com.study.lecture.application.Repository.LectureRepository;
import com.study.lecture.application.domain.LectureApplyDomain;
import com.study.lecture.application.domain.LectureDomain;
import com.study.lecture.application.domain.UserDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureServiceImpl implements LectureService {

    @Autowired
    LectureRepository lectureRepository;

    @Autowired
    LectureApplyRepository lectureApplyRepository;

    @Autowired
    LectureHistoryRepository lectureHistoryRepository;

    /**
     * 특강 신정 서비스
     * 1. 현재 특강 신청 인원 현황 조회
     * 2. 정원 초과 검증
     * 3. 특강 신청자 테이블 저장
     * 4. 특강 신청 이력 저장
     */
    @Override
    public LectureApplyDomain lectureApply(UserDomain user, LectureDomain lecture) {
        LectureDomain lectureDomain = lectureRepository.findById(lecture);
        lectureDomain.vaildateApplicantConutOverflow();
        lectureRepository.update(lectureDomain.countUpdate());
        LectureApplyDomain lectureApplyDomain = lectureApplyRepository.insert(user, lecture);
        lectureHistoryRepository.insert(user, lecture);
        return lectureApplyDomain;
    }

    /**
     * 특강 목록 조회 서비스
     * 여러 고려사항은 시간 관계상 구현하지 못하였습니다.
     */
    @Override
    public List<LectureDomain> getLectureList() {
        List<LectureDomain> lectureDomainList = lectureRepository.findAll();
        return lectureDomainList;
    }

    /**
     * 특강 신청 여부 조회
     */
    @Override
    public List<LectureDomain> getLectureApply(UserDomain user) {
        List<LectureDomain> lectureDomainList = lectureApplyRepository.findByUserId(user);
        return lectureDomainList;
    }
}
