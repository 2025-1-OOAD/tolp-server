package ooad.tolp.submission.repository;

import ooad.tolp.submission.domain.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {
    List<Submission> findAllByAssignmentId(Long assignmentId);
    List<Submission> findAllByQuizId(Long quizId);
    List<Submission> findAllByStudentId(Long studentId);
}