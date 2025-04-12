package ooad.tolp.dto.Request;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QnARequest {
    private Long writerId;
    private Long lectureId;
    private String content;
}