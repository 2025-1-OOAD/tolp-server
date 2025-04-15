package ooad.tolp.qna.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QnARequest {
    private Long writerId;
    private Long lectureId;
    private String content;
}