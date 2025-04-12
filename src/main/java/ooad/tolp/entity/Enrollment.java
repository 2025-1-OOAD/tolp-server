package ooad.tolp.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Enrollment {
    @Id @GeneratedValue
    private Long id;

    private LocalDateTime enrollmentDate;
    private LocalDateTime accessDeadline;

    @ManyToOne
    private User student;

    @ManyToOne
    private Lecture lecture;
}