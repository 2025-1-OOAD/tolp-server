package ooad.tolp.global.security.common.dto;

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