package ooad.tolp.dto;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuizRequest {
    private Long lectureId;
    private String title;
    private List<String> questionList;
    private LocalDateTime deadline;
}
