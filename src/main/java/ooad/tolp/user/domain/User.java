package ooad.tolp.user.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import ooad.tolp.assignment.domain.AssignmentSubmission;
import ooad.tolp.enrollment.domain.Enrollment;
import ooad.tolp.lecture.domain.Lecture;
import ooad.tolp.lecture.domain.QnA;
import ooad.tolp.timetable.domain.Timetable;
import ooad.tolp.todo.domain.Todo;

import java.time.LocalDateTime;
import java.util.List;

// 사용자의 정보를 나타내는 Entity 클래스
// JPA로 데이터베이스 테이블과 매핑되며, 사용자의 ID, 이메일, 비밀번호, 이름, 역할 등을 필드로 가짐
// 수강, 제출, 강의 Q&A 등 다양한 관계(@OneToMany, @OneToOne)도 포함

@Getter
@Table(name = "users")
@Setter
@NoArgsConstructor
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

    private String username;

    // 강의(강사)-User 1:N
    @OneToMany(mappedBy = "instructor")
    private List<Lecture> lectures;

    // 수강(학생)-User 1:N
    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollments;

    // 과제 제출-User 1:N
    @OneToMany(mappedBy = "student")
    private List<AssignmentSubmission> submissions;

    // 할 일-User 1:N
    @OneToMany(mappedBy = "user")
    private List<Todo> todos;

    //QnA 작성-User 1:N
    @OneToMany(mappedBy = "writer")
    private List<QnA> qnaList;

    // 시간표-User 1:1
    @OneToOne(mappedBy = "owner")
    private Timetable timetable;

    public enum Role {
        STUDENT, INSTRUCTOR
    }
}