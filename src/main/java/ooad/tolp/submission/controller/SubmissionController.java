package ooad.tolp.submission.controller;

import lombok.RequiredArgsConstructor;
import ooad.tolp.submission.dto.GradeRequest;
import ooad.tolp.submission.dto.SubmissionRequest;
import ooad.tolp.submission.dto.SubmissionResponse;
import ooad.tolp.submission.service.SubmissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/submissions")
@RequiredArgsConstructor
public class SubmissionController {

    private final SubmissionService submissionService;

    @PostMapping
    public ResponseEntity<SubmissionResponse> submit(@RequestBody SubmissionRequest request) {
        return ResponseEntity.ok(submissionService.submit(request));
    }

    @PostMapping("/grade")
    public ResponseEntity<SubmissionResponse> grade(@RequestBody GradeRequest request) {
        return ResponseEntity.ok(submissionService.grade(request));
    }
}
