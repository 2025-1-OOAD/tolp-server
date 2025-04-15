package ooad.tolp.quiz.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GradeRequest {
    private Long submissionId;
    private Integer score;
    private String feedback;
}