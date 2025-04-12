package ooad.tolp.dto.Request;


import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class LectureVideoRequest {
    private Long id;
    private String title;
    private String videoUrl;
    private LocalDateTime postedAt;
}
