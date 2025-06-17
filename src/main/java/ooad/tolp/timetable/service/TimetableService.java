package ooad.tolp.timetable.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import ooad.tolp.lecture.domain.Lecture;
import ooad.tolp.lecture.repository.LectureRepository;
import ooad.tolp.timetable.domain.Timetable;
import ooad.tolp.timetable.domain.TimetableLecture;
import ooad.tolp.timetable.dto.TimetableResponse;
import ooad.tolp.timetable.dto.TimetableLectureResponse;
import ooad.tolp.timetable.dto.TimetableUpdateRequest;
import ooad.tolp.timetable.repository.TimetableRepository;
import ooad.tolp.user.domain.User;
import ooad.tolp.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class TimetableService {

    private final TimetableRepository timetableRepository;
    private final UserRepository userRepository;
    private final LectureRepository lectureRepository;

    public TimetableResponse getTimetable(Long userId) {
        // TODO: 시간표 조회 처리
        Timetable timetable = timetableRepository.findByOwnerId(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자의 시간표가 존재하지 않습니다."));
        List<TimetableLectureResponse> lectureResponses = timetable.getTimetableLectures().stream()
                .map(tl -> {
                    TimetableLectureResponse res = new TimetableLectureResponse();
                    res.setLectureId(tl.getLecture().getId());
                    res.setLectureName(tl.getLecture().getName());
                    res.setCustomTime(tl.getCustomTime());
                    return res;
                })
                .collect(Collectors.toList());
        TimetableResponse response = new TimetableResponse();
        response.setUserId(userId);
        response.setLectures(lectureResponses);
        return response;
    }

    @Transactional
    public void addLectureToTimetable(TimetableUpdateRequest request) {
        // TODO: 시간표에 강의 추가 처리
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("사용자 없음"));
        Lecture lecture = lectureRepository.findById(request.getLectureId())
                .orElseThrow(() -> new IllegalArgumentException("강의 없음"));

        Timetable timetable = timetableRepository.findByOwnerId(user.getId())
                .orElseGet(() -> timetableRepository.save(new Timetable(user)));

        // 같은 강의가 이미 추가되어 있으면 무시
        boolean alreadyExists = timetable.getTimetableLectures().stream()
                        .anyMatch(tl -> tl.getLecture().getId().equals(lecture.getId()));
        if (alreadyExists) {
            throw new IllegalStateException("이미 추가된 강의입니다.");
        }

        TimetableLecture timetableLecture = new TimetableLecture(lecture, request.getCustomTime());
        timetable.getTimetableLectures().add(timetableLecture);
        timetableRepository.save(timetable);
    }

    @Transactional
    public void removeLectureFromTimetable(Long userId, Long lectureId) {
        // TODO: 시간표에서 강의 삭제 처리
        Timetable timetable = timetableRepository.findByOwnerId(userId)
                .orElseThrow(() -> new IllegalArgumentException("시간표 없음"));
        timetable.getTimetableLectures().removeIf(tl ->
                tl.getLecture().getId().equals(lectureId));
        timetableRepository.save(timetable);
    }

    @Transactional
    public void updateLectureTime(Long userId, Long lectureId, String newTime) {
        // TODO: 시간표 내 강의 시간 수정 처리
        Timetable timetable = timetableRepository.findByOwnerId(userId)
                .orElseThrow(() -> new IllegalArgumentException("시간표 없음"));
        timetable.updateLectureTime(lectureId, newTime);
        timetableRepository.save(timetable);
    }
}
