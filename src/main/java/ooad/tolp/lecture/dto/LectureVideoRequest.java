package ooad.tolp.lecture.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class LectureVideoRequest {
    private String title;
    private String videoUrl;
    private Long lectureId;
}