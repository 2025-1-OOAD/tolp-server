package ooad.tolp.submission.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class SubmissionRequest {
    private String content;
    private Long assignmentId;
    private Long quizId;
    private Long studentId;
}