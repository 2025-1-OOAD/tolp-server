package ooad.tolp.lecture.domain;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class LectureVideo {
    @Id @GeneratedValue
    private Long id;

    private String title;
    private String videoUrl;
    private LocalDateTime postedAt;
    private boolean isDeleted = false;


    @ManyToOne
    private Lecture lecture;
}