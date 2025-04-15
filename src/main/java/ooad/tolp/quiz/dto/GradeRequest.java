package ooad.tolp.quiz.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GradeRequest {
    private Long submissionId;
    private Integer score;
    private String feedback;
}