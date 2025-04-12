package ooad.tolp.dto.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GradeRequest {
    private Long submissionId;
    private Integer score;
    private String feedback;
}