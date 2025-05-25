package ooad.tolp.quiz.dto;

import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class QuizRequest {
    private String title;
    private List<String> questionList;
    private LocalDateTime deadline;
    private Long lectureId;
}
