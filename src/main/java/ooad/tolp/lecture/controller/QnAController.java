package ooad.tolp.lecture.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import ooad.tolp.common.jwt.JwtUtil;
import ooad.tolp.lecture.dto.QnARequest;
import ooad.tolp.lecture.dto.QnAResponse;
import ooad.tolp.lecture.service.QnAService;
import ooad.tolp.user.domain.User;
import ooad.tolp.user.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/qna")
@RequiredArgsConstructor
public class QnAController {

    private final QnAService qnaService;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    @PostMapping
    public ResponseEntity<QnAResponse> post(@RequestBody QnARequest request, HttpServletRequest httpRequest) {
        String email = jwtUtil.extractEmail(jwtUtil.resolveToken(httpRequest));
        User user = userRepository.findByEmail(email).orElseThrow();
        return ResponseEntity.ok(qnaService.postQnA(request, user));
    }

    @GetMapping("/board/{boardId}")
    public ResponseEntity<List<QnAResponse>> getByBoard(@PathVariable Long boardId) {
        return ResponseEntity.ok(qnaService.getQnAsByBoard(boardId));
    }

    @GetMapping("/my")
    public ResponseEntity<List<QnAResponse>> getMyQnAs(HttpServletRequest request) {
        String email = jwtUtil.extractEmail(jwtUtil.resolveToken(request));
        User user = userRepository.findByEmail(email).orElseThrow();
        return ResponseEntity.ok(qnaService.getQnAsByWriter(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        qnaService.deleteQnA(id);
        return ResponseEntity.noContent().build();
    }
}
