package ooad.tolp.lecture.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class QnARequest {
    private String content;
    private Long lectureId;
    private Long parentId;
}
