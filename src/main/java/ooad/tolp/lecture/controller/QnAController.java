package ooad.tolp.lecture.controller;

import ooad.tolp.lecture.dto.QnARequest;
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
    @PutMapping("/{id}")
    public ResponseEntity<String> updateQnA(@PathVariable Long id, @RequestBody QnARequest request) {
        // TODO: 질문 답글 수정
        return ResponseEntity.ok("수정 완료");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQnA(@PathVariable Long id) {
        // TODO: 질문 답글 삭제
        return ResponseEntity.ok("삭제 완료");
    }
}