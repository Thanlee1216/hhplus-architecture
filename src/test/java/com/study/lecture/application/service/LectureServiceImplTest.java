package com.study.lecture.application.service;

import com.study.lecture.application.Repository.LectureApplyRepository;
import com.study.lecture.application.Repository.LectureHistoryRepository;
import com.study.lecture.application.Repository.LectureRepository;
import com.study.lecture.application.domain.LectureApplyDomain;
import com.study.lecture.application.domain.LectureDomain;
import com.study.lecture.application.domain.UserDomain;
import com.study.lecture.infrastructure.exception.ApplyOverflowException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LectureServiceImplTest {

    @InjectMocks
    LectureServiceImpl service;

    @Mock
    LectureRepository lectureRepository;

    @Mock
    LectureApplyRepository lectureApplyRepository;

    @Mock
    LectureHistoryRepository lectureHistoryRepository;

    @Test
    @DisplayName("특강 신청에 성공하면 성공한 강의의 정보를 반환한다.")
    void lectureApplySuccess() {
        //given
        long userId = 1L;
        String userName = "이태한";
        long lectureId = 1L;
        String lectureName = "TDD 정말 어렵지만 할 수 있다!";
        String lectureDate = "20240724";

        UserDomain user = new UserDomain(userId, userName);
        LectureDomain lecture = new LectureDomain(lectureId, lectureName, lectureDate, 0);
        LectureApplyDomain lectureApplyDomain = new LectureApplyDomain(1L, userId, userName, lectureId, lectureName);
        when(lectureRepository.findById(lecture)).thenReturn(new LectureDomain(lectureId, lectureName, lectureDate, 0));
        when(lectureApplyRepository.insert(user, lecture)).thenReturn(lectureApplyDomain);

        //when
        LectureApplyDomain resultLectureApplyDomain = service.lectureApply(user, lecture);

        //then
        assertThat(resultLectureApplyDomain.id()).isEqualTo(lectureId);
    }

    @Test
    @DisplayName("신청한 특강의 정원 30명이 모두 찼을 경우 예외를 발생한다.")
    void lectureApplyFailOverFlow() {
        //given
        long userId = 1L;
        String userName = "이태한";
        long lectureId = 1L;
        String lectureName = "TDD 정말 어렵지만 할 수 있다!";
        String lectureDate = "20240724";

        UserDomain user = new UserDomain(userId, userName);
        LectureDomain lecture = new LectureDomain(lectureId, lectureName, lectureDate, 0);
        when(lectureRepository.findById(lecture)).thenReturn(new LectureDomain(lectureId, lectureName, lectureDate, 30));

        //when
        ApplyOverflowException e = assertThrows(ApplyOverflowException.class, () -> service.lectureApply(user, lecture));

        //then
        assertThat(e.getClass().getSimpleName()).isEqualTo("ApplyOverflowException");
    }

    @Test
    @DisplayName("전체 특강 목록을 조회해온다.")
    void getLectureListSuccess() {
        //given
        List<LectureDomain> lectureList = List.of(
                new LectureDomain(1L, "TDD 정말 어렵지만 할 수 있다!", "99990101", 0),
                new LectureDomain(2L, "TDD 정말 어렵지만 할 수 있다!!!", "99990102", 0)
        );
        when(lectureRepository.findAll()).thenReturn(lectureList);

        //when
        List<LectureDomain> resultLectureList = service.getLectureList();

        //then
        assertThat(resultLectureList.get(0).lectureId()).isEqualTo(lectureList.get(0).lectureId());
    }

    @Test
    @DisplayName("전체 특강 목록을 조회해온다.")
    void getLectureApplySuccess() {
        //given
        long userId = 1L;
        String userName = "이태한";
        List<LectureDomain> lectureList = List.of(
                new LectureDomain(1L, "TDD 정말 어렵지만 할 수 있다!", "99990101", 0),
                new LectureDomain(2L, "TDD 정말 어렵지만 할 수 있다!!!", "99990102", 0)
        );

        UserDomain user = new UserDomain(userId, userName);
        when(lectureApplyRepository.findByUserId(user)).thenReturn(lectureList);

        //when
        List<LectureDomain> resultLectureList = service.getLectureApply(user);

        //then
        assertThat(resultLectureList.get(0).lectureId()).isEqualTo(lectureList.get(0).lectureId());
    }

}