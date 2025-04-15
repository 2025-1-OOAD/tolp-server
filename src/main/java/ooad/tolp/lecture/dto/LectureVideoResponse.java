package ooad.tolp.lecture.dto;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LectureVideoResponse {
    private Long id;
    private String title;
    private String videoUrl;
    private LocalDateTime postedAt;
}
