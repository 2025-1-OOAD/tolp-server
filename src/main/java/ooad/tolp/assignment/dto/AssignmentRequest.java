package ooad.tolp.assignment.dto;

import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class AssignmentRequest {
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private Long lectureId;
}
