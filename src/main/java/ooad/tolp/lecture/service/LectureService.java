package ooad.tolp.lecture.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import ooad.tolp.lecture.domain.Lecture;
import ooad.tolp.lecture.domain.QnABoard;
import ooad.tolp.lecture.dto.LectureRequest;
import ooad.tolp.lecture.dto.LectureResponse;
import ooad.tolp.lecture.dto.LectureVideoRequest;
import ooad.tolp.lecture.repository.LectureRepository;
import ooad.tolp.lecture.repository.QnABoardRepository;
import ooad.tolp.user.domain.User;
import ooad.tolp.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class LectureService {

    private final LectureRepository lectureRepository;
    private final QnABoardRepository qnaBoardRepository;
    private final UserRepository userRepository;

    public List<LectureResponse> getLecturesByInstructor(Long instructorId) {
        return lectureRepository.findAllByInstructorId(instructorId).stream()
                .map(LectureResponse::fromEntity)
                .collect(Collectors.toList());
    }

    public LectureResponse createLecture(LectureRequest request, User instructor) {
        Lecture lecture = Lecture.builder()
                .name(request.getName())
                .syllabus(request.getSyllabus())
                .durationDays(request.getDurationDays())
                .instructor(instructor)
                .isDeleted(false)
                .build();

        QnABoard board = new QnABoard();
        board.setLecture(lecture);
        lecture.setQnaBoard(board);

        lectureRepository.save(lecture);
//        qnaBoardRepository.save(board);

        return LectureResponse.fromEntity(lectureRepository.save(lecture));
    }


    public LectureResponse updateLecture(Long id, LectureRequest request) {
        Lecture lecture = lectureRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lecture not found"));

        lecture.setName(request.getName());
        lecture.setSyllabus(request.getSyllabus());
        lecture.setDurationDays(request.getDurationDays());

        return LectureResponse.fromEntity(lecture);
    }

    @Transactional(readOnly = true)
    public LectureResponse getLecture(Long id) {
        Lecture lecture = lectureRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lecture not found"));
        return LectureResponse.fromEntity(lecture);
    }

    public List<LectureResponse> getAllLectures() {
        return lectureRepository.findAll().stream()
                .map(LectureResponse::fromEntity)
                .collect(Collectors.toList());
    }

}