package ooad.tolp.enrollment.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class EnrollmentRequest {
    private Long lectureId;
    private Long studentId;
}