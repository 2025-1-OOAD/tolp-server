package ooad.tolp.enrollment.dto;

import lombok.*;
import ooad.tolp.enrollment.domain.Enrollment;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class EnrollmentResponse {
    private Long id;
    private String lectureName;
    private String studentName;
    private LocalDateTime enrollmentDate;
    private LocalDateTime accessDeadline;

    public static EnrollmentResponse fromEntity(Enrollment e) {
        return EnrollmentResponse.builder()
                .id(e.getId())
                .lectureName(e.getLecture().getName())
                .studentName(e.getStudent().getName())
                .enrollmentDate(e.getEnrollmentDate())
                .accessDeadline(e.getAccessDeadline())
                .build();
    }
}