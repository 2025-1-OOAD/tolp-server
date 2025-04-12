package ooad.tolp.controller;
import ooad.tolp.dto.Request.LoginRequest;
import ooad.tolp.dto.Request.SignUpRequest;
import ooad.tolp.dto.Response.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody SignUpRequest request) {
        // TODO: 사용자 회원가입 처리
        return ResponseEntity.ok("회원가입 성공");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        // TODO: 로그인 처리
        return ResponseEntity.ok("로그인 성공");
    }

    @GetMapping("/me")
    public ResponseEntity<UserResponse> getMyInfo() {
        // TODO: 내 정보 조회 처리
        return ResponseEntity.ok(new UserResponse());
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        // TODO: 로그아웃 처리
        return ResponseEntity.ok("로그아웃 성공");
    }

    @DeleteMapping("/withdraw")
    public ResponseEntity<String> deleteAccount() {
        // TODO: 탈퇴 처리
        return ResponseEntity.ok("유저 삭제");
    }

}