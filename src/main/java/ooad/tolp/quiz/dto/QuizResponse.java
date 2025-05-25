package ooad.tolp.quiz.dto;

import lombok.*;
import ooad.tolp.quiz.domain.Quiz;
import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class QuizResponse {
    private Long id;
    private String title;
    private List<String> questionList;
    private LocalDateTime deadline;

    public static QuizResponse fromEntity(Quiz quiz) {
        return QuizResponse.builder()
                .id(quiz.getId())
                .title(quiz.getTitle())
                .questionList(quiz.getQuestionList())
                .deadline(quiz.getDeadline())
                .build();
    }
}