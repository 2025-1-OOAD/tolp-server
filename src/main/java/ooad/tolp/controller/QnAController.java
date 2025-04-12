package ooad.tolp.controller;

import ooad.tolp.dto.QnARequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/qna")
public class QnAController {

    @PostMapping
    public ResponseEntity<String> postQuestion(@RequestBody QnARequest request) {
        // TODO: 질문 등록 처리
        return ResponseEntity.ok("질문 등록 완료");
    }

    @PostMapping("/{parentId}/reply")
    public ResponseEntity<String> replyToQuestion(@PathVariable Long parentId, @RequestBody QnARequest request) {
        // TODO: 답글 등록 처리
        return ResponseEntity.ok("답글 등록 완료");
    }
}