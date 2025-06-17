package ooad.tolp.lecture.dto;

import lombok.*;
import ooad.tolp.lecture.domain.LectureVideo;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class LectureVideoResponse {
    private Long id;
    private String title;
    private String videoUrl;
    private LocalDateTime postedAt;

    public static LectureVideoResponse fromEntity(LectureVideo video) {
        return LectureVideoResponse.builder()
                .id(video.getId())
                .title(video.getTitle())
                .videoUrl(video.getVideoUrl())
                .postedAt(video.getPostedAt())
                .build();
    }
}