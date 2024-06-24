package com.study.lecture.presentation.controller;

import com.study.lecture.presentation.dto.request.LectureRequestDTO;
import com.study.lecture.presentation.dto.response.LectureResponseDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lecture")
public class LectureController {

    /**
     * 특강 신청 API
     */
    @PostMapping("apply")
    public LectureResponseDTO apply(@RequestBody LectureRequestDTO dto) {
        return new LectureResponseDTO();
    }

    /**
     * 특강 신청 여부 조회 API
     */
    @GetMapping("application/{userId}")
    public boolean getLectureHistory(@PathVariable String userId) {
        return false;
    }
}
