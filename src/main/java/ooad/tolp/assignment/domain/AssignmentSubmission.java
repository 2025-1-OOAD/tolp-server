package ooad.tolp.assignment.domain;
import jakarta.persistence.*;
import ooad.tolp.quiz.domain.Quiz;
import ooad.tolp.user.domain.User;

import java.time.LocalDateTime;

@Entity
public class AssignmentSubmission {
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