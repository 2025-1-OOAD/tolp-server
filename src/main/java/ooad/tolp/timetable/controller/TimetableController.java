package ooad.tolp.timetable.controller;

import lombok.RequiredArgsConstructor;

import ooad.tolp.timetable.dto.TimetableResponse;
import ooad.tolp.timetable.dto.TimetableUpdateRequest;
import ooad.tolp.timetable.service.TimetableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/timetable")
@RequiredArgsConstructor
public class TimetableController {

    private final TimetableService timetableService;

    @GetMapping("/{userId}")
    public ResponseEntity<TimetableResponse> getTimetable(@PathVariable Long userId) {
        return ResponseEntity.ok(timetableService.getTimetable(userId));
    }

    @PostMapping("/add")
    public ResponseEntity<String> addLecture(@RequestBody TimetableUpdateRequest request) {
        // TODO: 시간표에 강의 추가
        timetableService.addLectureToTimetable(request);
        return ResponseEntity.ok("강의 추가 완료");
    }

    @DeleteMapping("/{userId}/lecture/{lectureId}")
    public ResponseEntity<String> removeLectureFromTimetable(@PathVariable Long userId, @PathVariable Long lectureId){
        // TODO: 시간표에 강의 삭제
        timetableService.removeLectureFromTimetable(userId, lectureId);
        return ResponseEntity.ok("강의 삭제 완료");
    }

    @PutMapping("/{userId}/lecture/{lectureId}")
    public ResponseEntity<String> updateLectureTime(@PathVariable Long userId, @PathVariable Long lectureId, @RequestBody TimetableUpdateRequest request){
        // TODO: 시간표에 있는 강의 수정
        timetableService.updateLectureTime(userId, lectureId, request.getCustomTime());
        return ResponseEntity.ok("강의 시간 수정 완료");
    }

}
