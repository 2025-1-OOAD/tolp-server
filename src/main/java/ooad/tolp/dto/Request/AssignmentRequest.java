package ooad.tolp.dto.Request;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssignmentRequest {
    private Long lectureId;
    private String title;
    private String description;
    private LocalDateTime dueDate;
}