package ooad.tolp.dto;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequest {
    private String email;
    private String password;
    private String name;
    private String role;
}