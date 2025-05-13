package ooad.tolp.enrollment.controller;

import lombok.RequiredArgsConstructor;
import ooad.tolp.enrollment.dto.EnrollmentRequest;
import ooad.tolp.enrollment.service.EnrollmentService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<String> enroll(@RequestBody EnrollmentRequest request) {
        // TODO: 수강 신청 처리
        enrollmentService.enroll(request);
        return ResponseEntity.ok("수강 신청 완료");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancel(@PathVariable Long id) {
        // TODO: 수강 취소 처리
        enrollmentService.cancelEnrollment(id);
        return ResponseEntity.ok("수강 취소 완료");
    }
}