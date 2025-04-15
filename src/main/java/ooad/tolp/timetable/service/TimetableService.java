package ooad.tolp.timetable.service;

import ooad.tolp.timetable.dto.TimetableUpdateRequest;
import org.springframework.stereotype.Service;

@Service
public class TimetableService {

    public void getTimetable(Long userId) {
        // TODO: 시간표 조회 처리
    }

    public void addLectureToTimetable(TimetableUpdateRequest request) {
        // TODO: 시간표에 강의 추가 처리
    }

    public void removeLectureFromTimetable(Long userId, Long lectureId) {
        // TODO: 시간표에서 강의 삭제 처리
    }

    public void updateLectureTime(Long userId, Long lectureId) {
        // TODO: 시간표 내 강의 시간 수정 처리
    }
}
