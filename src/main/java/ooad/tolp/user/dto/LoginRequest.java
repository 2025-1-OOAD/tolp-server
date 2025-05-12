package ooad.tolp.user.dto;
import lombok.Getter;
import lombok.Setter;

// 로그인 시 사용자가 전달하는 데이터를 담는 요청 DTO(Data Transfer Object) 클래스

@Getter
@Setter
public class LoginRequest {
    private String email;
    private String password;
}