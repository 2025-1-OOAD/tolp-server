package ooad.tolp.user.domain;

import lombok.*;

import jakarta.persistence.*;
import ooad.tolp.assignment.domain.AssignmentSubmission;
import ooad.tolp.enrollment.domain.Enrollment;
import ooad.tolp.lecture.domain.Lecture;
import ooad.tolp.lecture.domain.QnA;
import ooad.tolp.timetable.domain.Timetable;
import ooad.tolp.todo.domain.Todo;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id @GeneratedValue
    private Long id;

    private String email;
    private String password;
    private String name;
    private String username;

    @Enumerated(EnumType.STRING)
    private Role role;

    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public enum Role {
        STUDENT, INSTRUCTOR
    }

    // 연관관계 설정
    @OneToMany(mappedBy = "instructor")
    private List<Lecture> lectures;

    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollments;

    @OneToMany(mappedBy = "student")
    private List<AssignmentSubmission> submissions;

    @OneToMany(mappedBy = "user")
    private List<Todo> todos;

    @OneToMany(mappedBy = "writer")
    private List<QnA> qnaList;

    @OneToOne(mappedBy = "owner")
    private Timetable timetable;
}
