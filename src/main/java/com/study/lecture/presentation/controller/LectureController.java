package com.study.lecture.presentation.controller;

import com.study.lecture.application.domain.LectureApplyDomain;
import com.study.lecture.application.domain.LectureDomain;
import com.study.lecture.application.domain.UserDomain;
import com.study.lecture.application.service.LectureService;
import com.study.lecture.presentation.dto.request.LectureApplyRequestDTO;
import com.study.lecture.presentation.dto.response.LectureApplyResponseDTO;
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
    public LectureApplyResponseDTO apply(@RequestBody LectureApplyRequestDTO dto) {
        LectureApplyDomain lectureApplyDomain = service.lectureApply(dto.convertToUserDomain(), dto.convertToLectureDomain());
        return LectureApplyResponseDTO.of(lectureApplyDomain);
    }

    /**
     * 특강 목록 조회
     */
    @GetMapping("")
    public List<LectureResponseDTO> getLectureList() {
        List<LectureDomain> lectureList = service.getLectureList();
        return LectureResponseDTO.converteFromLectureDomainToDtoList(lectureList);
    }

    /**
     * 특강 신청 여부 조회 API
     */
    @GetMapping("application/{userId}")
    public List<LectureResponseDTO> getLectureApply(@PathVariable long userId) {
        List<LectureDomain> lectureList = service.getLectureApply(new UserDomain(userId, null));
        return LectureResponseDTO.converteFromLectureDomainToDtoList(lectureList);
    }
}
