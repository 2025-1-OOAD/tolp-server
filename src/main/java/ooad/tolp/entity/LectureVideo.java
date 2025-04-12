package ooad.tolp.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class LectureVideo {
    @Id @GeneratedValue
    private Long id;

    private String title;
    private String videoUrl;
    private LocalDateTime postedAt;

    @ManyToOne
    private Lecture lecture;
}