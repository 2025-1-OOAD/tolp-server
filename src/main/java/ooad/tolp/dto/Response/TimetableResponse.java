package ooad.tolp.dto.Response;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class TimetableResponse {
    private Long userId;
    private List<String> lectures;
}
