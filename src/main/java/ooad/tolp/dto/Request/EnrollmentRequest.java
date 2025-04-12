package ooad.tolp.dto.Request;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnrollmentRequest {
    private Long studentId;
    private Long lectureId;
}