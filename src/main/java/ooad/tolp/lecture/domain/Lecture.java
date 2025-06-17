package ooad.tolp.lecture.domain;

import jakarta.persistence.*;
import lombok.*;
import ooad.tolp.assignment.domain.Assignment;
import ooad.tolp.enrollment.domain.Enrollment;
import ooad.tolp.quiz.domain.Quiz;
import ooad.tolp.user.domain.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Lecture {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String syllabus;
    private int durationDays;
    private boolean isDeleted = false;
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id")
    private User instructor;

    @OneToMany(mappedBy = "lecture", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LectureVideo> videos = new ArrayList<>();

    @OneToMany(mappedBy = "lecture", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Assignment> assignments = new ArrayList<>();

    @OneToMany(mappedBy = "lecture", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Quiz> quizzes = new ArrayList<>();

    @OneToMany(mappedBy = "lecture", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Enrollment> enrollments = new ArrayList<>();

    @OneToOne(mappedBy = "lecture", cascade = CascadeType.ALL, orphanRemoval = true)
    private QnABoard qnaBoard;

    public void addVideo(LectureVideo video) {
        videos.add(video);
        video.setLecture(this);
    }
    public void addAssignment(Assignment a) {
        assignments.add(a);
        a.setLecture(this);
    }
    public void addQuiz(Quiz q) {
        quizzes.add(q);
        q.setLecture(this);
    }
    public void addEnrollment(Enrollment e) {
        enrollments.add(e);
        e.setLecture(this);
    }
    public void setQnaBoard(QnABoard board) {
        this.qnaBoard = board;
        board.setLecture(this);
    }
}