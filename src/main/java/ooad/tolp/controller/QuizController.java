package ooad.tolp.controller;

import ooad.tolp.dto.QuizAnswerRequest;
import ooad.tolp.dto.QuizRequest;
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
}