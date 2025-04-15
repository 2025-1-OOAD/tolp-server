package ooad.tolp.enrollment.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnrollmentRequest {
    private Long studentId;
    private Long lectureId;
}