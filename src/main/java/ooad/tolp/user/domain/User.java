package ooad.tolp.user.domain;
import jakarta.persistence.*;
import ooad.tolp.assignment.domain.Submission;
import ooad.tolp.enrollment.domain.Enrollment;
import ooad.tolp.lecture.domain.Lecture;
import ooad.tolp.qna.domain.QnA;
import ooad.tolp.timetable.domain.Timetable;
import ooad.tolp.todo.domain.Todo;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class User {
    @Id @GeneratedValue
    private Long id;

    private String email;
    private String password;
    private String name;

    @Enumerated(EnumType.STRING)
    private Role role;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "instructor")
    private List<Lecture> lectures;

    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollments;

    @OneToMany(mappedBy = "student")
    private List<Submission> submissions;

    @OneToMany(mappedBy = "user")
    private List<Todo> todos;

    @OneToMany(mappedBy = "writer")
    private List<QnA> qnaList;

    @OneToOne(mappedBy = "owner")
    private Timetable timetable;

    public enum Role {
        STUDENT, INSTRUCTOR
    }
}