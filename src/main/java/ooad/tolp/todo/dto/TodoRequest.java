package ooad.tolp.todo.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoRequest {
    private Long userId;
    private String content;
}