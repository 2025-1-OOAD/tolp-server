package ooad.tolp.lecture.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import ooad.tolp.common.jwt.JwtUtil;
import ooad.tolp.lecture.dto.LectureRequest;
import ooad.tolp.lecture.dto.LectureResponse;
import ooad.tolp.lecture.service.LectureService;
import ooad.tolp.user.domain.User;
import ooad.tolp.user.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lectures")
@RequiredArgsConstructor
public class LectureController {

    private final LectureService lectureService;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    @PostMapping
    public ResponseEntity<LectureResponse> createLecture(@RequestBody LectureRequest request, HttpServletRequest httpRequest) {
        String email = jwtUtil.extractEmail(jwtUtil.resolveToken(httpRequest));
        User user = userRepository.findByEmail(email).orElseThrow();
        return ResponseEntity.ok(lectureService.createLecture(request, user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LectureResponse> updateLecture(@PathVariable Long id, @RequestBody LectureRequest request) {
        return ResponseEntity.ok(lectureService.updateLecture(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LectureResponse> getLecture(@PathVariable Long id) {
        return ResponseEntity.ok(lectureService.getLecture(id));
    }

    @GetMapping
    public ResponseEntity<List<LectureResponse>> getAllLectures() {
        return ResponseEntity.ok(lectureService.getAllLectures());
    }

    @GetMapping("/my")
    public ResponseEntity<List<LectureResponse>> getMyLecturesAsInstructor(HttpServletRequest request) {
        String email = jwtUtil.extractEmail(jwtUtil.resolveToken(request));
        User user = userRepository.findByEmail(email).orElseThrow();
        return ResponseEntity.ok(lectureService.getLecturesByInstructor(user.getId()));
    }
}