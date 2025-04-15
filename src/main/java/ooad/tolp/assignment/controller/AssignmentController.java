package ooad.tolp.assignment.controller;

import ooad.tolp.assignment.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lectures/{lectureId}/assignments")
public class AssignmentController {

    @PostMapping
    public ResponseEntity<String> createAssignment(@PathVariable Long lectureId, @RequestBody AssignmentRequest request) {
        // TODO: 과제 등록
        return ResponseEntity.ok("과제 등록 완료");
    }

    @PostMapping("/{assignmentId}/submit")
    public ResponseEntity<String> submitAssignment(@PathVariable Long lectureId, @PathVariable Long assignmentId, @RequestBody SubmissionRequest request) {
        // TODO: 과제 제출
        return ResponseEntity.ok("과제 제출 완료");
    }

    @PostMapping("/grade")
    public ResponseEntity<String> gradeSubmission(@PathVariable Long lectureId, @RequestBody GradeRequest request) {
        // TODO: 과제 채점
        return ResponseEntity.ok("과제 채점 완료");
    }

    @GetMapping("/submissions/{submissionId}")
    public ResponseEntity<SubmissionResponse> getAssignmentResult(@PathVariable Long lectureId, @PathVariable Long submissionId) {
        // TODO: 과제 결과 조회
        return ResponseEntity.ok(new SubmissionResponse());
    }
}