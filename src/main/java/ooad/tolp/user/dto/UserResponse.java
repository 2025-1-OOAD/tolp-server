package ooad.tolp.user.dto;

import lombok.Getter;
import lombok.Setter;

// 로그인 성공 또는 GET /me 등에서 사용자 정보를 클라이언트에게 반환할 때 사용하는 응답 DTO

@Getter
@Setter
public class UserResponse {
    private Long id;
    private String email;
    private String name;
    private String role;
}
