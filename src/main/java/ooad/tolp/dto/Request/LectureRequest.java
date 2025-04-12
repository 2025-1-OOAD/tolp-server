package ooad.tolp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class LectureRequest {
    private String title;
    private String syllabus;
    private int durationDays;
    private Long instructorId;
}

