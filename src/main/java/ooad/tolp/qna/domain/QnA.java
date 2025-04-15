package ooad.tolp.qna.domain;
import jakarta.persistence.*;
import ooad.tolp.lecture.domain.QnABoard;
import ooad.tolp.user.domain.User;

import java.time.LocalDateTime;


@Entity
public class QnA {
    @Id @GeneratedValue
    private Long id;

    private String content;
    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;
    private boolean isDeleted = false;

    @ManyToOne
    private User writer;

    @ManyToOne
    private QnABoard board;

    @ManyToOne
    private QnA parent;
}