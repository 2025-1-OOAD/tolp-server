package ooad.tolp.entity;
import jakarta.persistence.*;
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