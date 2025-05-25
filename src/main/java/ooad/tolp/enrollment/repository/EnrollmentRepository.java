package ooad.tolp.enrollment.repository;

import ooad.tolp.enrollment.domain.Enrollment;
import ooad.tolp.lecture.domain.Lecture;
import ooad.tolp.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    boolean existsByStudentAndLecture(User student, Lecture lecture);
    List<Enrollment> findAllByStudentId(Long studentId);
    List<Enrollment> findAllByLectureId(Long lectureId);
}
