package com.study.lecture;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.lecture.application.Repository.LectureRepository;
import com.study.lecture.application.domain.LectureDomain;
import com.study.lecture.application.service.LectureService;
import com.study.lecture.infrastructure.exception.ExceptionType;
import com.study.lecture.presentation.dto.request.LectureApplyRequestDTO;
import com.study.lecture.presentation.dto.response.LectureApplyResponseDTO;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@AutoConfigureMockMvc
@SpringBootTest
public class LectureIntegreationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private WebApplicationContext ctx;


    @Autowired
    LectureService lectureService;

    @Autowired
    LectureRepository lectureRepository;

    LectureDomain lectureDomain1;
    LectureDomain lectureDomain2;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx)
                .addFilters(new CharacterEncodingFilter("UTF-8", true)) // 필터 추가
                .alwaysDo(print())
                .build();

        lectureDomain1 = new LectureDomain(1L, "TDD를 정복해보자", "20270402", 0L);
        lectureDomain2 = new LectureDomain(2L, "PR을 잘 작성해보다", "20260402", 30L);

        lectureRepository.save(lectureDomain1);
        lectureRepository.save(lectureDomain2);
    }

    @Test
    @DisplayName("특강 신청에 성공하면 성공한 강의의 정보를 반환한다.")
    void lectureApplySuccess() throws Exception {
        //given
        long userId = 1L;
        String userName = "이태한";
        long lectureId = lectureDomain1.lectureId();
        String lectureName = lectureDomain1.lectureName();
        String lectureDate = lectureDomain1.date();
        LectureApplyRequestDTO requestDTO = new LectureApplyRequestDTO(userId, userName, lectureId, lectureName, lectureDate);
        LectureApplyResponseDTO responseDTO = new LectureApplyResponseDTO(userId, userName, lectureId, lectureName);

        ObjectMapper objectMapper = new ObjectMapper();

        //when
        ResultActions resultActions = mockMvc.perform(post("/lectures/apply").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(requestDTO)));

        //then
        resultActions.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(responseDTO.userId()))
                .andExpect(jsonPath("$.lectureId").value(responseDTO.lectureId()));
    }

    @Test
    @DisplayName("특강 신청에 실패하면 예외를 반환한다.")
    void lectureApplyFail() throws Exception {
        //given
        long userId = 1L;
        String userName = "이태한";
        long lectureId = lectureDomain2.lectureId();
        String lectureName = lectureDomain2.lectureName();
        String lectureDate = lectureDomain2.date();
        LectureApplyRequestDTO requestDTO = new LectureApplyRequestDTO(userId, userName, lectureId, lectureName, lectureDate);

        ObjectMapper objectMapper = new ObjectMapper();

        //when
        ResultActions resultActions = mockMvc.perform(post("/lectures/apply").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(requestDTO)));

        //then
        resultActions.andDo(print())
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.message").value(ExceptionType.getMessage("ApplyFail")));
    }

    @Test
    @DisplayName("특강의 목록을 조회한다.")
    void getLectureListSuccess() throws Exception {
        //given

        //when
        ResultActions resultActions = mockMvc.perform(get("/lectures"));

        //then
        resultActions.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].lectureId").value(lectureDomain1.lectureId()))
                .andExpect(jsonPath("$[1].lectureId").value(lectureDomain2.lectureId()));
    }

    @Test
    @DisplayName("수강 신청에 성공한 특강의 목록을 조회한다.")
    void getLectureApplyListSuccess() throws Exception {
        //given
        long userId = 1L;
        String userName = "이태한";
        long lectureId = lectureDomain1.lectureId();
        String lectureName = lectureDomain1.lectureName();
        String lectureDate = lectureDomain1.date();
        LectureApplyRequestDTO requestDTO = new LectureApplyRequestDTO(userId, userName, lectureId, lectureName, lectureDate);

        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(post("/lectures/apply").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(requestDTO)));

        //when
        ResultActions resultActions = mockMvc.perform(get("/lectures/application/" + userId));

        //then
        resultActions.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].lectureId").value(lectureDomain1.lectureId()));
    }
}
