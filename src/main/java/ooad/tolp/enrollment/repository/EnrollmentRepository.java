package ooad.tolp.enrollment.repository;

import ooad.tolp.enrollment.domain.Enrollment;
import ooad.tolp.lecture.domain.Lecture;
import ooad.tolp.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    boolean existsByStudentAndLecture(User student, Lecture lecture);
}
