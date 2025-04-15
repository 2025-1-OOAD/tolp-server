package ooad.tolp.quiz.controller;

import ooad.tolp.quiz.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lectures/{lectureId}/quizzes")
public class QuizController {

    @PostMapping
    public ResponseEntity<String> createQuiz(@PathVariable Long lectureId, @RequestBody QuizRequest request) {
        // TODO: 퀴즈 등록
        return ResponseEntity.ok("퀴즈 등록 완료");
    }

    @PostMapping("/{quizId}/submit")
    public ResponseEntity<String> submitQuiz(@PathVariable Long lectureId, @PathVariable Long quizId, @RequestBody QuizAnswerRequest request) {
        // TODO: 퀴즈 제출
        return ResponseEntity.ok("퀴즈 제출 완료");
    }

    @PostMapping("/grade")
    public ResponseEntity<String> gradeQuiz(@PathVariable Long lectureId, @RequestBody GradeRequest request) {
        // TODO: 퀴즈 채점
        return ResponseEntity.ok("퀴즈 채점 완료");
    }

    @GetMapping("/submissions/{submissionId}")
    public ResponseEntity<SubmissionResponse> getQuizResult(@PathVariable Long lectureId, @PathVariable Long submissionId) {
        // TODO: 퀴즈 결과 조회
        return ResponseEntity.ok(new SubmissionResponse());
    }
}