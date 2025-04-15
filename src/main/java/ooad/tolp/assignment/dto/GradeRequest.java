package ooad.tolp.assignment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GradeRequest {
    private Long submissionId;
    private Integer score;
    private String feedback;
}