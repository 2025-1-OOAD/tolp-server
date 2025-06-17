package ooad.tolp.submission.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class GradeRequest {
    private Long submissionId;
    private Integer score;
    private String feedback;
}
