package ooad.tolp.lecture.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class LectureRequest {
    private String name;
    private String syllabus;
    private int durationDays;
    private Long instructorId;
}
