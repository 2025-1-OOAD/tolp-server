package ooad.tolp.quiz.service;

import ooad.tolp.assignment.dto.GradeRequest;
import ooad.tolp.quiz.dto.QuizRequest;
import ooad.tolp.assignment.dto.SubmissionRequest;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

    public void createQuiz(QuizRequest request) {
        // TODO: 퀴즈 등록 처리
    }

    public void submitQuiz(Long id, SubmissionRequest request) {
        // TODO: 퀴즈 제출 처리
    }

    public void gradeQuiz(GradeRequest request) {
        // TODO: 퀴즈 채점 처리
    }

    public void getQuizResult(Long submissionId) {
        // TODO: 퀴즈 결과 조회 처리
    }
}