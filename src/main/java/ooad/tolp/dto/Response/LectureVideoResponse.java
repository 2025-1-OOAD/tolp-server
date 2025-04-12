package ooad.tolp.dto.Response;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class LectureVideoResponse {
    private Long id;
    private String title;
    private String videoUrl;
    private LocalDateTime postedAt;
}
