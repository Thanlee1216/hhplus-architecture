package com.study.lecture.presentation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.lecture.application.domain.LectureApplyDomain;
import com.study.lecture.application.service.LectureService;
import com.study.lecture.presentation.dto.request.LectureRequestDTO;
import com.study.lecture.presentation.dto.response.LectureResponseDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = LectureController.class)
@ExtendWith(SpringExtension.class)
class LectureControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    LectureService lectureService;

    @Test
    @DisplayName("특강 신청에 성공하면 성공한 강의의 정보를 반환한다.")
    void lectureApplySuccess() throws Exception {
        //given
        long userId = 1L;
        String userName = "이태한";
        long lectureId = 1L;
        String lectureName = "TDD 정말 어렵지만 할 수 있다!";
        LectureRequestDTO requestDTO = new LectureRequestDTO(userId, userName, lectureId, lectureName);
        LectureResponseDTO responseDTO = new LectureResponseDTO(userId, userName, lectureId, lectureName);
        LectureApplyDomain applyDomain = new LectureApplyDomain(1L, userId, userName, lectureId, lectureName);

        when(lectureService.lectureApply(requestDTO.convertToUserDomain(), requestDTO.convertToLectureDomain())).thenReturn(applyDomain);

        ObjectMapper objectMapper = new ObjectMapper();

        //when
        ResultActions resultActions = mockMvc.perform(post("/lectures/apply").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(requestDTO)));

        //then
        resultActions.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(responseDTO.userId()))
                .andExpect(jsonPath("$.lectureId").value(responseDTO.lectureId()));
    }

}