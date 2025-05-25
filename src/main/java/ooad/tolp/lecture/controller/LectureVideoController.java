package ooad.tolp.lecture.controller;

import lombok.RequiredArgsConstructor;
import ooad.tolp.lecture.dto.LectureVideoRequest;
import ooad.tolp.lecture.dto.LectureVideoResponse;
import ooad.tolp.lecture.service.LectureVideoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lecture-videos")
@RequiredArgsConstructor
public class LectureVideoController {

    private final LectureVideoService lectureVideoService;

    @PostMapping
    public ResponseEntity<LectureVideoResponse> upload(@RequestBody LectureVideoRequest request) {
        return ResponseEntity.ok(lectureVideoService.uploadVideo(request));
    }

    @GetMapping("/lecture/{lectureId}")
    public ResponseEntity<List<LectureVideoResponse>> getByLecture(@PathVariable Long lectureId) {
        return ResponseEntity.ok(lectureVideoService.getVideosByLecture(lectureId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        lectureVideoService.deleteVideo(id);
        return ResponseEntity.noContent().build();
    }
}