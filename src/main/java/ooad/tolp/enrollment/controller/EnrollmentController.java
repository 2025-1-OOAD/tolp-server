package ooad.tolp.enrollment.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import ooad.tolp.common.jwt.JwtUtil;
import ooad.tolp.enrollment.dto.EnrollmentRequest;
import ooad.tolp.enrollment.dto.EnrollmentResponse;
import ooad.tolp.enrollment.service.EnrollmentService;

import ooad.tolp.user.domain.User;
import ooad.tolp.user.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    @PostMapping
    public ResponseEntity<EnrollmentResponse> enroll(@RequestBody EnrollmentRequest request, HttpServletRequest httpRequest) {
        String email = jwtUtil.extractEmail(jwtUtil.resolveToken(httpRequest));
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("사용자 없음"));
        return ResponseEntity.ok(enrollmentService.enroll(request, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancel(@PathVariable Long id) {
        enrollmentService.cancelEnrollment(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/myLectures")
    public ResponseEntity<List<EnrollmentResponse>> getMyEnrollments(HttpServletRequest request) {
        String email = jwtUtil.extractEmail(jwtUtil.resolveToken(request));
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("사용자 없음"));
        return ResponseEntity.ok(enrollmentService.getEnrollmentsByStudent(user.getId()));
    }
}