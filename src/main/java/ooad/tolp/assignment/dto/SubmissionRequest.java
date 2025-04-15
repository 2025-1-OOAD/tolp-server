package ooad.tolp.assignment.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubmissionRequest {
    private String content;
    private Long assignmentId; // nullable
    private Long quizId;       // nullable
}