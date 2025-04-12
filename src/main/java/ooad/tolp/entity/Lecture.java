package ooad.tolp.entity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;


@Entity
public class Lecture {
    @Id @GeneratedValue
    private Long id;

    private String title;
    private String syllabus;
    private int durationDays;
    private boolean isDeleted = false;
    private LocalDateTime createdAt;


    @ManyToOne
    private User instructor;

    @OneToMany(mappedBy = "lecture")
    private List<LectureVideo> videos;

    @OneToMany(mappedBy = "lecture")
    private List<Assignment> assignments;

    @OneToMany(mappedBy = "lecture")
    private List<Quiz> quizzes;

    @OneToMany(mappedBy = "lecture")
    private List<Enrollment> enrollments;

    @OneToOne(mappedBy = "lecture")
    private QnABoard qnaBoard;
}