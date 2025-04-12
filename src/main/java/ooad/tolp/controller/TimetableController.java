package ooad.tolp.controller;

import ooad.tolp.dto.Request.TimetableUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/timetable")
public class TimetableController {

    @GetMapping("/{userId}")
    public ResponseEntity<String> getTimetable(@PathVariable Long userId) {
        // TODO: 시간표 조회
        return ResponseEntity.ok("시간표 반환");
    }

    @PostMapping("/add")
    public ResponseEntity<String> addLecture(@RequestBody TimetableUpdateRequest request) {
        // TODO: 시간표에 강의 추가
        return ResponseEntity.ok("강의 추가 완료");
    }
    @DeleteMapping("/{userId}/lecture/{lectureId}")
    public ResponseEntity<String> removeLectureFromTimetable(){
        // TODO: 시간표에 강의 삭제
        return ResponseEntity.ok("강의 삭제 완료");
    }

    @PutMapping("/{userId}/lecture/{lectureId}")
    public ResponseEntity<String> updateLectureTime(){
        // TODO: 시간표에 있는 강의 수정
        return ResponseEntity.ok("강의 수정 완료");
    }

}
