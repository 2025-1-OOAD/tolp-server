package ooad.tolp.timetable.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimetableLectureResponse {
    private Long lectureId;
    private String lectureName;
    private String customTime;
}
