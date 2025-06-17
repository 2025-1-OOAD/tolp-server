package ooad.tolp.submission.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import ooad.tolp.assignment.domain.Assignment;
import ooad.tolp.assignment.repository.AssignmentRepository;
import ooad.tolp.quiz.domain.Quiz;
import ooad.tolp.quiz.repository.QuizRepository;
import ooad.tolp.submission.domain.Submission;
import ooad.tolp.submission.dto.GradeRequest;
import ooad.tolp.submission.dto.SubmissionRequest;
import ooad.tolp.submission.dto.SubmissionResponse;
import ooad.tolp.submission.repository.SubmissionRepository;
import ooad.tolp.user.domain.User;
import ooad.tolp.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class SubmissionService {

    private final SubmissionRepository submissionRepository;
    private final AssignmentRepository assignmentRepository;
    private final QuizRepository quizRepository;
    private final UserRepository userRepository;

    public SubmissionResponse submit(SubmissionRequest request) {
        User student = userRepository.findById(request.getStudentId())
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));

        Submission submission = Submission.builder()
                .content(request.getContent())
                .submittedAt(LocalDateTime.now())
                .student(student)
                .build();

        if (request.getAssignmentId() != null) {
            Assignment assignment = assignmentRepository.findById(request.getAssignmentId())
                    .orElseThrow(() -> new EntityNotFoundException("Assignment not found"));
            submission.setAssignment(assignment);
        }

        if (request.getQuizId() != null) {
            Quiz quiz = quizRepository.findById(request.getQuizId())
                    .orElseThrow(() -> new EntityNotFoundException("Quiz not found"));
            submission.setQuiz(quiz);
        }

        return SubmissionResponse.fromEntity(submissionRepository.save(submission));
    }

    public SubmissionResponse grade(GradeRequest request) {
        Submission submission = submissionRepository.findById(request.getSubmissionId())
                .orElseThrow(() -> new EntityNotFoundException("Submission not found"));

        submission.setScore(request.getScore());
        submission.setFeedback(request.getFeedback());
        submission.setGradedAt(LocalDateTime.now());

        return SubmissionResponse.fromEntity(submission);
    }
}