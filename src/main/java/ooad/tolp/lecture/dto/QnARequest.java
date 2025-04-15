package ooad.tolp.lecture.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QnARequest {
    private String content;
    private Long parentId; // null일 경우 질문, 값이 있으면 댓글/대댓글
}