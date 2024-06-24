package com.study.lecture.presentation;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lecture")
public class LectureController {

    /**
     * 특강 신청 API
     */
    @PostMapping("apply")
    public LectureDTO apply(@RequestBody LectureDTO dto) {
        return new LectureDTO();
    }

    /**
     * 특강 신청 여부 조회 API
     */
    @GetMapping("application/{userId}")
    public boolean getLectureHistory(@PathVariable String userId) {
        return false;
    }
}
