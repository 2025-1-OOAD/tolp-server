package ooad.tolp.enrollment.domain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ooad.tolp.lecture.domain.Lecture;
import ooad.tolp.user.domain.User;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
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