package ooad.tolp.lecture.controller;

import lombok.RequiredArgsConstructor;
import ooad.tolp.lecture.dto.LectureRequest;
import ooad.tolp.lecture.dto.LectureResponse;
import ooad.tolp.lecture.service.LectureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lectures")
@RequiredArgsConstructor
public class LectureController {

    private final LectureService lectureService;

    @PostMapping
    public ResponseEntity<LectureResponse> createLecture(@RequestBody LectureRequest request) {
        return ResponseEntity.ok(lectureService.createLecture(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LectureResponse> updateLecture(@PathVariable Long id, @RequestBody LectureRequest request) {
        return ResponseEntity.ok(lectureService.updateLecture(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LectureResponse> getLecture(@PathVariable Long id) {
        return ResponseEntity.ok(lectureService.getLecture(id));
    }
}
