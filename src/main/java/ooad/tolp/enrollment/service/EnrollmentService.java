package ooad.tolp.enrollment.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import ooad.tolp.enrollment.domain.Enrollment;
import ooad.tolp.enrollment.dto.EnrollmentRequest;
import ooad.tolp.enrollment.dto.EnrollmentResponse;
import ooad.tolp.enrollment.repository.EnrollmentRepository;
import ooad.tolp.lecture.domain.Lecture;
import ooad.tolp.lecture.repository.LectureRepository;
import ooad.tolp.user.domain.User;
import ooad.tolp.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final UserRepository userRepository;
    private final LectureRepository lectureRepository;

    // 수강신청 처리
    @Transactional
    public void enroll(EnrollmentRequest request) {
        User student = userRepository.findById(request.getStudentId())
                .orElseThrow(() -> new IllegalArgumentException("해당 학생을 찾을 수 없습니다."));
        Lecture lecture = lectureRepository.findById(request.getLectureId())
                .orElseThrow(() -> new IllegalArgumentException("해당 강의를 찾을 수 없습니다."));

        // 중복 수강 신청 방지
        if (enrollmentRepository.existsByStudentAndLecture(student, lecture)) {
            throw new IllegalArgumentException("이미 신청한 강의입니다.");
        }

        Enrollment enrollment = Enrollment.builder()
                .lecture(lecture)
                .student(student)
                .enrollmentDate(LocalDateTime.now())
                .accessDeadline(LocalDateTime.now().plusDays(lecture.getDurationDays()))
                .build();

        return EnrollmentResponse.fromEntity(enrollmentRepository.save(enrollment));
    }

    // 수강 취소 처리
    @Transactional
    public void cancelEnrollment(Long id) {
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("수강 내역을 찾을 수 없습니다."));
        enrollmentRepository.delete(enrollment);

    }

    @Transactional(readOnly = true)
    public List<EnrollmentResponse> getEnrollmentsByStudent(Long studentId) {
        return enrollmentRepository.findAllByStudentId(studentId).stream()
                .map(EnrollmentResponse::fromEntity)
                .collect(Collectors.toList());
    }
}
