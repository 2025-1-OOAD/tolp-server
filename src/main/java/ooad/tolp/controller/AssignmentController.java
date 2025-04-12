package ooad.tolp.controller;

import ooad.tolp.dto.AssignmentRequest;
import ooad.tolp.dto.SubmissionRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

    @PostMapping
    public ResponseEntity<String> createAssignment(@RequestBody AssignmentRequest request) {
        // TODO: 과제 등록 처리
        return ResponseEntity.ok("과제 등록 완료");
    }

    @PostMapping("/{id}/submit")
    public ResponseEntity<String> submitAssignment(@PathVariable Long id, @RequestBody SubmissionRequest request) {
        // TODO: 과제 제출 처리
        return ResponseEntity.ok("과제 제출 완료");
    }
}
