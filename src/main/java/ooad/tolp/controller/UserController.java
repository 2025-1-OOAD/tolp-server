package ooad.tolp.controller;
import ooad.tolp.dto.LoginRequest;
import ooad.tolp.dto.SignUpRequest;
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
}