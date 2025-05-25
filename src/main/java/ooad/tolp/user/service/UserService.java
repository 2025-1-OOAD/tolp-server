package ooad.tolp.user.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import ooad.tolp.common.jwt.JwtUtil;
import ooad.tolp.user.domain.User;
import ooad.tolp.user.dto.LoginRequest;
import ooad.tolp.user.dto.SignUpRequest;
import ooad.tolp.user.dto.UserResponse;
import ooad.tolp.user.repository.UserRepository;
import ooad.tolp.todo.repository.TodoRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TodoRepository todoRepository;
    private final JwtUtil jwtUtil;

    public void signUp(SignUpRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
        }

        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .role(request.getRole())
                .build();

        userRepository.save(user);
    }

    public String login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("등록되지 않은 사용자입니다."));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
        }

        return jwtUtil.generateToken(user);
    }

    public void deleteAccount(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new EntityNotFoundException("사용자를 찾을 수 없습니다.");
        }
        todoRepository.deleteByUserId(userId);
        userRepository.deleteById(userId);
    }

    @Transactional(readOnly = true)
    public UserResponse getMyInfo(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("사용자를 찾을 수 없습니다."));

        return UserResponse.fromEntity(user);
    }
}
