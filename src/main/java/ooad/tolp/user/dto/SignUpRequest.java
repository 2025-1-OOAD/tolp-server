package ooad.tolp.user.dto;
import lombok.Getter;
import lombok.Setter;

// 회원가입 시 사용자가 입력하는 데이터를 담는 요청 DTO

@Getter
@Setter
public class SignUpRequest {
    private String email;
    private String password;
    private String name;
    private String role;
}