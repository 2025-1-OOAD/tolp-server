package ooad.tolp.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
public class Assignment {
    @Id @GeneratedValue
    private Long id;

    private String title;
    private String description;
    private LocalDateTime dueDate;

    @ManyToOne
    private Lecture lecture;

    @OneToMany(mappedBy = "assignment")
    private List<Submission> submissions;
}