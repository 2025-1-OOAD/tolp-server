package ooad.tolp.timetable.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class TimetableResponse {
    private Long userId;
    private List<TimetableLectureResponse> lectures;
}
