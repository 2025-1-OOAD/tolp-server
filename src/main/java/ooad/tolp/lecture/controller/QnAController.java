package ooad.tolp.qna.controller;

import lombok.RequiredArgsConstructor;
import ooad.tolp.lecture.dto.QnARequest;
import ooad.tolp.lecture.dto.QnAResponse;
import ooad.tolp.lecture.service.QnAService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/qna")
@RequiredArgsConstructor
public class QnAController {

    private final QnAService qnaService;

    @PostMapping
    public ResponseEntity<QnAResponse> post(@RequestBody QnARequest request) {
        return ResponseEntity.ok(qnaService.postQnA(request));
    }

    @GetMapping("/board/{boardId}")
    public ResponseEntity<List<QnAResponse>> getByBoard(@PathVariable Long boardId) {
        return ResponseEntity.ok(qnaService.getQnAsByBoard(boardId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        qnaService.deleteQnA(id);
        return ResponseEntity.noContent().build();
    }
}
