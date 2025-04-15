package ooad.tolp.assignment.dto;

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