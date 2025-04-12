package ooad.tolp.dto.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoResponse {
    private Long id;
    private String content;
    private boolean completed;
}
