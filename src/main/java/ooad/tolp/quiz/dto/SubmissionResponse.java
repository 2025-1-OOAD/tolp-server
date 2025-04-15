package ooad.tolp.quiz.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class SubmissionResponse {
    private Long id;
    private Integer score;
    private String feedback;
    private LocalDateTime gradedAt;
}