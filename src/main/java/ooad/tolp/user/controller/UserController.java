package ooad.tolp.user.controller;

import lombok.RequiredArgsConstructor;
import ooad.tolp.user.dto.LoginRequest;
import ooad.tolp.user.dto.SignUpRequest;
import ooad.tolp.user.dto.UserResponse;
import ooad.tolp.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody SignUpRequest request) {
        userService.signUp(request);
        return ResponseEntity.ok("회원가입 성공");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        userService.login(request);
        return ResponseEntity.ok("로그인 성공");
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getMyInfo(id));
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        userService.logout();
        return ResponseEntity.ok("로그아웃 성공");
    }

    @DeleteMapping("/withdraw")
    public ResponseEntity<String> deleteAccount(@RequestParam Long userId) {
        userService.deleteAccount(userId);
        return ResponseEntity.ok("유저 삭제");
    }
}
