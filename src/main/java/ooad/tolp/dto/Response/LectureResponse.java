package ooad.tolp.dto.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LectureResponse {
    private Long id;
    private String title;
    private String syllabus;
    private String instructorName;
}
