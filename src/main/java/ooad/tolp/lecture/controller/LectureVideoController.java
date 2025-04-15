package ooad.tolp.lecture.controller;

import ooad.tolp.lecture.dto.LectureVideoRequest;
import ooad.tolp.lecture.dto.LectureVideoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/lectures/{lectureId}/videos")
public class LectureVideoController {

    @PutMapping("/{videoId}")
    public ResponseEntity<String> updateVideo(@PathVariable Long lectureId, @PathVariable Long videoId, @RequestBody LectureVideoRequest request) {
        // TODO: 강의 영상 업로드
        return ResponseEntity.ok("강의 영상 업로드 완료");
    }

    @DeleteMapping("/{videoId}")
    public ResponseEntity<String> deleteVideo(@PathVariable Long lectureId, @PathVariable Long videoId) {
        // TODO: 강의 영상 삭제
        return ResponseEntity.ok("강의 영상 삭제 완료");
    }

    @GetMapping
    public ResponseEntity<List<LectureVideoResponse>> getLectureVideos(@PathVariable Long lectureId) {
        // TODO: 강의 영상 리스트 반환
        return ResponseEntity.ok(new ArrayList<>());
    }
}