package ooad.tolp.assignment.dto;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubmissionResponse {
    private Long id;
    private String content;
    private Integer score;
    private String feedback;
    private LocalDateTime submittedAt;
    private LocalDateTime gradedAt;
}