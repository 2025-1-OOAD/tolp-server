package ooad.tolp.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
public class QnA {
    @Id @GeneratedValue
    private Long id;

    private String content;
    private LocalDateTime createdAt;

    @ManyToOne
    private User writer;

    @ManyToOne
    private QnABoard board;

    @ManyToOne
    private QnA parent;
}