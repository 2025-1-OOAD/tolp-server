package ooad.tolp.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Submission {
    @Id @GeneratedValue
    private Long id;

    private String content;
    private LocalDateTime submittedAt;
    private Integer score;
    private String feedback;
    private LocalDateTime gradedAt;

    @ManyToOne
    private User student;

    @ManyToOne
    private Assignment assignment;

    @ManyToOne
    private Quiz quiz;
}