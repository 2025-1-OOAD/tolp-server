package ooad.tolp.quiz.controller;

import ooad.tolp.assignment.dto.GradeRequest;
import ooad.tolp.quiz.dto.QuizAnswerRequest;
import ooad.tolp.quiz.dto.QuizRequest;
import ooad.tolp.assignment.dto.SubmissionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    @PostMapping
    public ResponseEntity<String> createQuiz(@RequestBody QuizRequest request) {
        // TODO: 퀴즈 등록 처리
        return ResponseEntity.ok("퀴즈 등록 완료");
    }

    @PostMapping("/{id}/submit")
    public ResponseEntity<String> submitQuiz(@PathVariable Long id, @RequestBody QuizAnswerRequest request) {
        // TODO: 퀴즈 제출 처리
        return ResponseEntity.ok("퀴즈 제출 완료");
    }
    @PostMapping("/grade")
    public ResponseEntity<String> gradeSubmission(@RequestBody GradeRequest request){
        // TODO: 성적 부여
        return ResponseEntity.ok("퀴즈 채점 완료");
    }

    @GetMapping("/submissions/{submissionId}")
    public ResponseEntity<SubmissionResponse> getQuizResult(@PathVariable Long submissionId){
        SubmissionResponse submission = new SubmissionResponse();
        submission.setId(submissionId);
        // TODO: 점수 확인
        return ResponseEntity.ok(submission);
    }

}