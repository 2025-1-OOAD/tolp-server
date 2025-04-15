package ooad.tolp.user.service;

import ooad.tolp.user.dto.LoginRequest;
import ooad.tolp.user.dto.SignUpRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void signUp(SignUpRequest request) {
        // TODO: 사용자 회원가입 처리
    }

    public void login(LoginRequest request) {
        // TODO: 로그인 처리
    }

    public void logout() {
        // TODO: 로그아웃 처리
    }

    public void deleteAccount(Long userId) {
        // TODO: 회원 탈퇴 처리
    }

    public void getMyInfo(Long userId) {
        // TODO: 내 정보 조회
    }
}