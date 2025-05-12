package ooad.tolp.user.controller;
import ooad.tolp.user.dto.LoginRequest;
import ooad.tolp.user.dto.SignUpRequest;
import ooad.tolp.user.dto.UserResponse;
import ooad.tolp.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

// 사용자 관련 HTTP 요청을 처리하는 Controller 클래스
// REST API의 엔드포인트를 제공하며, 요청을 UserService로 전달

@RestController                 // 해당 클래스가 REST API의 컨트롤러임을 명시
@RequestMapping("/api/users")   // 공통 URL, 이 컨트롤러의 모든 요청은 "/api/users"로 시작
@RequiredArgsConstructor        // final 필드에 대한 생성자를 자동으로 생성해주는 Lombok 애너테이션
public class UserController {

    // ✅ Lombok이 생성자를 만들어 주입해주기 위한 final 선언
    private final UserService userService;

    // 회원가입 엔드포인트
    @PostMapping("/signup")     // POST 요청 "/api/users/signup"
    public ResponseEntity<String> signUp(@RequestBody SignUpRequest request) {
        // TODO: 사용자 회원가입 처리
        userService.signUp(request);        // 클라이언트로부터 받은 회원가입 요청 정보를 UserService로 전달
        return ResponseEntity.ok("회원가입 성공");        // 회원가입 성공 메시지를 HTTP 200 응답으로 반환
    }

    // 로그인 엔드포인트
    @PostMapping("/login")      // POST 요청 "/api/users/login"
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        // TODO: 로그인 처리
        // 로그인 요청 정보를 UserService로 전달하여 인증 처리
        userService.login(request);
        return ResponseEntity.ok("로그인 성공");     // 로그인 성공 메시지를 HTTP 200 응답으로 반환
    }



    // 내 정보 조회 엔드포인트
    @GetMapping("/me")      // GET 요청 "/api/users/me"
    public ResponseEntity<UserResponse> getMyInfo(@RequestParam Long userId) {
        // TODO: 내 정보 조회 처리
        UserResponse dto = userService.getMyInfo(userId);       // 전달받은 userId를 통해 사용자 정보를 조회
        return ResponseEntity.ok(dto);
    }

    // 로그아웃
    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        // TODO: 로그아웃 처리
        userService.logout();
        return ResponseEntity.ok("로그아웃 성공");
    }


    // 회원 탈퇴
    @DeleteMapping("/withdraw")     // DELETE 요청 "/api/users/withdraw"
    public ResponseEntity<String> deleteAccount(@RequestParam Long userId) {
        // TODO: 탈퇴 처리
        userService.deleteAccount(userId);      // 전달받은 userId로 계정 삭제 처리
        return ResponseEntity.ok("유저 삭제");
    }

}