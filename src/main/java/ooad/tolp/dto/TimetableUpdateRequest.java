package ooad.tolp.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimetableUpdateRequest {
    private Long userId;
    private Long lectureId;
}