package ooad.tolp.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import ooad.tolp.user.domain.User;
import ooad.tolp.user.dto.LoginRequest;
import ooad.tolp.user.dto.SignUpRequest;
import ooad.tolp.user.dto.UserResponse;
import ooad.tolp.user.repository.UserRepository;
import ooad.tolp.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ooad.tolp.common.jwt.JwtUtil;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody SignUpRequest request) {
        userService.signUp(request);
        return ResponseEntity.ok("회원가입 성공");
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest request) {
        String token = userService.login(request);
        return ResponseEntity.ok(Map.of("token", token));
    }

    @GetMapping("/user-info")
    public ResponseEntity<UserResponse> getMyInfo(HttpServletRequest request) {
        String token = jwtUtil.resolveToken(request);
        String email = jwtUtil.extractEmail(token);
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));
        return ResponseEntity.ok(UserResponse.fromEntity(user));
    }

    @DeleteMapping("/withdraw")
    public ResponseEntity<String> deleteAccount(@RequestParam Long userId) {
        userService.deleteAccount(userId);
        return ResponseEntity.ok("유저 삭제");
    }
}
