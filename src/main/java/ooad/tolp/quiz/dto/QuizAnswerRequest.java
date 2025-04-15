package ooad.tolp.quiz.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuizAnswerRequest {
    private Long studentId;
    private String content;
}