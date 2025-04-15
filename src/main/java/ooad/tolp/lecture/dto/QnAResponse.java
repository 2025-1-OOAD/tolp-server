package ooad.tolp.lecture.dto;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QnAResponse {
    private Long id;
    private String content;
    private String writerName;
    private LocalDateTime createdAt;
    private boolean isReply;
    private Long parentId;
}