package ooad.tolp.enrollment.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import ooad.tolp.enrollment.domain.Enrollment;
import ooad.tolp.enrollment.dto.EnrollmentRequest;
import ooad.tolp.enrollment.repository.EnrollmentRepository;
import ooad.tolp.lecture.domain.Lecture;
import ooad.tolp.lecture.repository.LectureRepository;
import ooad.tolp.user.domain.User;
import ooad.tolp.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final UserRepository userRepository;
    private final LectureRepository lectureRepository;

    // 수강신청 처리
    @Transactional
    public void enroll(EnrollmentRequest request) {
        // TODO: 수강 신청 처리
        User student = userRepository.findById(request.getStudentId())
                .orElseThrow(() -> new IllegalArgumentException("해당 학생을 찾을 수 없습니다."));
        Lecture lecture = lectureRepository.findById(request.getLectureId())
                .orElseThrow(() -> new IllegalArgumentException("해당 강의를 찾을 수 없습니다."));


        // 중복 수강 신청 방지
        if (enrollmentRepository.existsByStudentAndLecture(student, lecture)) {
            throw new IllegalArgumentException("이미 신청한 강의입니다.");
        }
    }

    public void cancelEnrollment(Long id) {
        // TODO: 수강 취소 처리
    }
}
