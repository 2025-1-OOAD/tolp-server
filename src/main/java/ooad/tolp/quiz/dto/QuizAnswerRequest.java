package ooad.tolp.quiz.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuizAnswerRequest {
    private Long quizId;
    private String content;
}