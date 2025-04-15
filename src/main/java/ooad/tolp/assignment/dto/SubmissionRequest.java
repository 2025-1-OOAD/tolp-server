package ooad.tolp.assignment.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubmissionRequest {
    private Long studentId;
    private String content;
}