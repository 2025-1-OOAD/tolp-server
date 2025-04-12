package ooad.tolp.dto.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    private Long id;
    private String email;
    private String name;
    private String role;
}
