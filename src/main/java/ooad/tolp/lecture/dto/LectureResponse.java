package ooad.tolp.lecture.dto;

import lombok.*;
import ooad.tolp.lecture.domain.Lecture;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class LectureResponse {
    private Long id;
    private String name;
    private String syllabus;
    private int durationDays;
    private String instructorName;
    private LocalDateTime createdAt;

    public static LectureResponse fromEntity(Lecture lecture) {
        return LectureResponse.builder()
                .id(lecture.getId())
                .name(lecture.getName())
                .syllabus(lecture.getSyllabus())
                .durationDays(lecture.getDurationDays())
                .instructorName(lecture.getInstructor().getName())
                .createdAt(lecture.getCreatedAt())
                .build();
    }
}