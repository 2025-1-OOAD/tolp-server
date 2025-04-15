package ooad.tolp.quiz.service;

import ooad.tolp.quiz.dto.*;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

    public void createQuiz(Long lectureId, QuizRequest request) {
        // TODO: 퀴즈 등록 처리
    }

    public void submitQuiz(Long lectureId, Long quizId, QuizAnswerRequest request) {
        // TODO: 퀴즈 제출 처리
    }

    public void gradeQuiz(Long lectureId, GradeRequest request) {
        // TODO: 퀴즈 채점 처리
    }

    public SubmissionResponse getQuizResult(Long lectureId, Long submissionId) {
        // TODO: 퀴즈 결과 조회 처리
        return new SubmissionResponse();
    }
}
