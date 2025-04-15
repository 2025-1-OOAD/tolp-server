package ooad.tolp.quiz.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import ooad.tolp.assignment.domain.Assignment;
import ooad.tolp.user.domain.User;

import java.time.LocalDateTime;

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