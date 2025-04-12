package ooad.tolp.service;

import ooad.tolp.dto.Request.GradeRequest;
import ooad.tolp.dto.Request.QuizRequest;
import ooad.tolp.dto.Request.SubmissionRequest;
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
