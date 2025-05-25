package ooad.tolp.lecture.dto;

import lombok.*;
import ooad.tolp.lecture.domain.QnA;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class QnAResponse {
    private Long id;
    private String content;
    private String writerName;
    private LocalDateTime createdAt;
    private boolean isDeleted;
    private Long parentId;

    public static QnAResponse fromEntity(QnA qna) {
        return QnAResponse.builder()
                .id(qna.getId())
                .content(qna.getContent())
                .writerName(qna.getWriter().getName())
                .createdAt(qna.getCreatedAt())
                .isDeleted(qna.isDeleted())
                .parentId(qna.getParent() != null ? qna.getParent().getId() : null)
                .build();
    }
}