import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    @Test
    void signUp_정상작동확인() {
        // given
        SignUpRequest request = new SignUpRequest("test@example.com", "password123");

        UserService userService = new UserService();

        // when & then
        assertDoesNotThrow(() -> userService.signUp(request));
    }
}
