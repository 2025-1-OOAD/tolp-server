package ooad.tolp.quiz.controller;

import lombok.RequiredArgsConstructor;
import ooad.tolp.quiz.dto.QuizRequest;
import ooad.tolp.quiz.dto.QuizResponse;
import ooad.tolp.quiz.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @PostMapping
    public ResponseEntity<QuizResponse> create(@RequestBody QuizRequest request) {
        return ResponseEntity.ok(quizService.createQuiz(request));
    }

    @GetMapping("/lecture/{lectureId}")
    public ResponseEntity<List<QuizResponse>> getByLecture(@PathVariable Long lectureId) {
        return ResponseEntity.ok(quizService.getQuizzesByLecture(lectureId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        quizService.deleteQuiz(id);
        return ResponseEntity.noContent().build();
    }
}
