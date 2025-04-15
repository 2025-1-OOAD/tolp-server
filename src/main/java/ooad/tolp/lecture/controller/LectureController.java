package ooad.tolp.lecture.controller;

import ooad.tolp.lecture.dto.LectureRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lectures")
public class LectureController {

    @PostMapping
    public ResponseEntity<String> createLecture(@RequestBody LectureRequest request) {
        // TODO: 강의 개설 처리
        return ResponseEntity.ok("강의 개설 완료");
    }

    @PutMapping("/{lectureId}")
    public ResponseEntity<String> updateLecture(@PathVariable Long lectureId, @RequestBody LectureRequest request) {
        // TODO: 강의 수정 처리
        return ResponseEntity.ok("강의 수정 완료");
    }

    @GetMapping("/search")
    public ResponseEntity<String> searchLecture(@RequestParam String keyword) {
        // TODO: 강의 검색 처리
        return ResponseEntity.ok("검색 결과 반환");
    }
}