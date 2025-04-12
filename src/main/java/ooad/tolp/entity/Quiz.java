package ooad.tolp.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Quiz {
    @Id @GeneratedValue
    private Long id;

    private String title;

    @ElementCollection
    private List<String> questionList;

    private LocalDateTime deadline;

    @ManyToOne
    private Lecture lecture;

    @OneToMany(mappedBy = "quiz")
    private List<Submission> submissions;
}