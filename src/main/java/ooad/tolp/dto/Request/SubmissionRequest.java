package ooad.tolp.dto.Request;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubmissionRequest {
    private Long studentId;
    private String content;
}