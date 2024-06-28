package com.study.lecture.application.service;

import com.study.lecture.application.Repository.LectureRepository;
import com.study.lecture.application.domain.LectureDomain;
import com.study.lecture.application.domain.UserDomain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
public class LectureServiceConcurrencyTest {

    @Autowired
    LectureService lectureService;

    @Autowired
    LectureRepository lectureRepository;

    LectureDomain lectureDomain1;
    LectureDomain lectureDomain2;

    @BeforeEach
    void setUp() {
        lectureDomain1 = new LectureDomain(1L, "TDD를 정복해보자", "20270402", 0L);
        lectureDomain2 = new LectureDomain(2L, "PR을 잘 작성해보다", "20260402", 30L);

        lectureRepository.save(lectureDomain1);
        lectureRepository.save(lectureDomain2);
    }

    @Test
    @DisplayName("동시성 테스트 - 비관적락")
    public void concurrencyPessimisticLockTest() throws InterruptedException {
        int count = 100;
        UserDomain user = new UserDomain(1L, "이태한");
        LectureDomain lecture = new LectureDomain(1L, "TDD 강의", "20240401", 0);

        ExecutorService executorService = Executors.newFixedThreadPool(32);
        CountDownLatch latch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            executorService.execute(() -> {
                try{
                    lectureService.lectureApply(user, lecture);
                }catch (Exception e){
                    e.printStackTrace();
                }
                latch.countDown();
            });
        }
        latch.await();

        List<LectureDomain> lectureDomainList = lectureService.getLectureApply(user);
        assertThat(lectureDomainList.size()).isEqualTo(30);
    }
}
