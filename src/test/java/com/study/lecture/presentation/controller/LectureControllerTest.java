package com.study.lecture.presentation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.lecture.application.service.LectureService;
import com.study.lecture.presentation.dto.request.LectureRequestDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

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
    void 특강을_신청한다() throws Exception {
        //given
//        long userId = 1L;
//        long lectureId = 1L;
//        LectureRequestDTO lectureRequestDTO = new LectureRequestDTO(userId, lectureId);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        //when
//        ResultActions resultActions = mockMvc.perform(post("/lecture/apply").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(lectureRequestDTO)));
//
//        //then
//        resultActions.andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.userId").value(userId))
//                .andExpect(jsonPath("$.lectureId").value(lectureId));
    }
}