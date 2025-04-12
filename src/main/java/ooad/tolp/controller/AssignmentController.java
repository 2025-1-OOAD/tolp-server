package ooad.tolp.controller;

import ooad.tolp.dto.Request.AssignmentRequest;
import ooad.tolp.dto.Request.GradeRequest;
import ooad.tolp.dto.Request.SubmissionRequest;
import ooad.tolp.dto.Response.SubmissionResponse;
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
    @PostMapping("/grade")
    public ResponseEntity<String> gradeSubmission(@RequestBody GradeRequest request){
        // TODO: 성적 부여
        return ResponseEntity.ok("과제 채점 완료");
    }

    @GetMapping("/submissions/{submissionId}")
    public ResponseEntity<SubmissionResponse> getAssignmentResult(@PathVariable Long submissionId){
        SubmissionResponse submission = new SubmissionResponse();
        submission.setId(submissionId);
        // TODO: 점수 확인
        return ResponseEntity.ok(submission);
    }
}
