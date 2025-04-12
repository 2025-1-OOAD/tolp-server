package ooad.tolp.controller;

import ooad.tolp.dto.TimetableUpdateRequest;
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
}
