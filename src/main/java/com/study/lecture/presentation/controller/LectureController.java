package com.study.lecture.presentation.controller;

import com.study.lecture.application.domain.LectureApplyDomain;
import com.study.lecture.application.service.LectureService;
import com.study.lecture.presentation.dto.request.LectureRequestDTO;
import com.study.lecture.presentation.dto.response.LectureResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lectures")
public class LectureController {

    @Autowired
    LectureService service;
    /**
     * 특강 신청 API
     */
    @PostMapping("apply")
    public LectureResponseDTO apply(@RequestBody LectureRequestDTO dto) {
        LectureApplyDomain lectureApplyDomain = service.lectureApply(dto.convertToUserDomain(), dto.convertToLectureDomain());
        return new LectureResponseDTO(lectureApplyDomain.userId(), lectureApplyDomain.userName(), lectureApplyDomain.lectureId(), lectureApplyDomain.lectureName());
    }

    @GetMapping("")
    public List<LectureResponseDTO> getLectureList() {
        return List.of();
    }

    /**
     * 특강 신청 여부 조회 API
     */
    @GetMapping("application/{userId}")
    public boolean getLectureHistory(@PathVariable String userId) {
        return false;
    }
}
