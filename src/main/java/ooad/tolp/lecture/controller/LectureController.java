package ooad.tolp.lecture.controller;

import ooad.tolp.lecture.dto.LectureRequest;
import ooad.tolp.lecture.dto.LectureVideoRequest;
import ooad.tolp.lecture.dto.LectureVideoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/lectures")
public class LectureController {

    @PostMapping
    public ResponseEntity<String> createLecture(@RequestBody LectureRequest request) {
        // TODO: 강의 개설 처리
        return ResponseEntity.ok("강의 개설 완료");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateLecture(@PathVariable Long id, @RequestBody LectureRequest request) {
        // TODO: 강의 수정 처리
        return ResponseEntity.ok("강의 수정 완료");
    }

    @GetMapping("/search")
    public ResponseEntity<String> searchLecture(@RequestParam String keyword) {
        // TODO: 강의 검색 처리
        return ResponseEntity.ok("검색 결과 반환");
    }

    @PutMapping("/videos/{videoId}")
    public ResponseEntity<String> updateVideo(@PathVariable Long videoId, @RequestBody LectureVideoRequest request){
        // TODO: 강의 영상 업로드
        return ResponseEntity.ok("강의 영상 업로드");
    }

    @DeleteMapping("/videos/{videoId}")
    public ResponseEntity<String> deleteVideo(@PathVariable Long videoId){
        // TODO: 강의 영상 삭제
        return ResponseEntity.ok("강의 영상 삭제");
    }

    @GetMapping("/{lectureId}/videos")
    public ResponseEntity<List<LectureVideoResponse>> getLectureVideos(@PathVariable Long lectureId) {
        List<LectureVideoResponse> videos = new ArrayList<>();
        // TODO: 실제 서비스 호출
        return ResponseEntity.ok(videos);
    }

}