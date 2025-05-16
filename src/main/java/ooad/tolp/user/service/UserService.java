package ooad.tolp.user.service;

import ooad.tolp.user.dto.LoginRequest;
import ooad.tolp.user.dto.SignUpRequest;
import ooad.tolp.user.dto.UserResponse;
import ooad.tolp.user.domain.User;
import ooad.tolp.user.domain.User.Role;
import ooad.tolp.user.repository.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


// 이클래스틑 서비스 레이어임을 나타냄 스프링 빈으로 등록
// final 필드 자동 생성자 주입
// 생성자 주입을 자동으로 해주는 Lombok 애너테이션
@Service
@RequiredArgsConstructor
public class UserService {

    // JPA를 이용한 DB 접근용 리포지토리
    private final UserRepository userRepository;

    // BCryptpasswordEncoder 등 (비밀번호 암호화를 위한 인터페이스)
    private final PasswordEncoder passwordEncoder;

    // 1) 이메일 중복 체크
    // 2) 비밀번호 암호화
    // 3) User entity 생성 및 저장
    // 회원가입 처리 메서드
    @Transactional
    public void signUp(SignUpRequest request) {
        // TODO: 사용자 회원가입 처리
        // 이메일 중복 검사
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
        }

        // User 객체 생성
        User user = new User();
        user.setEmail(request.getEmail());      // 이메일 저장
        user.setPassword(passwordEncoder.encode(request.getPassword()));        // 비밀번호 암호화 후 저장
        user.setName(request.getName());        // 이름 저장
        user.setRole(User.Role.valueOf(request.getRole().toUpperCase()));       // 역할 문자열을 enum으로 변환
        user.setCreatedAt(java.time.LocalDateTime.now());


        // DB에 저장
        userRepository.save(user);
    }



    // 1) 이메일로 User 조회
    // 2) 비밀번호 일치 여부 확인
    // 3) (성공 시) 세션/JWT 발급 또는 상태 변경
    // 로그인 처리 메서드
    public void login(LoginRequest request) {
        // TODO: 로그인 처리

        // 이메일로 사용자 조회
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("등록되지 않은 사용자입니다."));

        // 비밀번호 일치 여부 확인
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        // TODO: 세션 생성 or JWT 발급 로직
    }


    // 로그아웃 처리
    // 세션 무효화 or JWT 무효화
    public void logout() {
        // TODO: 로그아웃 처리
    }


    // 회원 탈퇴
    // 1) 존재 여부 확인
    // 2) 삭제
    public void deleteAccount(Long userId) {
        // TODO: 회원 탈퇴 처리
        if (!userRepository.existsById(userId)) {
            throw new IllegalArgumentException("사용자를 찾을 수 없습니다.");
        }
        userRepository.deleteById(userId);
    }



    // 내 정보 조회
    // 1) User 엔티티 조회
    // 2) UserResponse DTO 변환
    public UserResponse getMyInfo(Long userId) {
        // TODO: 내 정보 조회
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        UserResponse dto = new UserResponse();
        dto.setId(user.getId());    //ID
        dto.setEmail(user.getEmail());  //Email
        dto.setName(user.getName());    //이름
        dto.setRole(user.getRole().name());     // 역할(String)

        return dto;
    }
}