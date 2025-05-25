package ooad.tolp.user.dto;

import lombok.*;
import ooad.tolp.user.domain.User;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class SignUpRequest {
    private String email;
    private String password;
    private String name;
//    private String username;
    private User.Role role;
}