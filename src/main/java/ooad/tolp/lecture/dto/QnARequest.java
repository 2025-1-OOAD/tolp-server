package ooad.tolp.lecture.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class QnARequest {
    private String content;
    private Long boardId;
    private Long writerId;
    private Long parentId;
}