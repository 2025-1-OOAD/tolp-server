package ooad.tolp.entity;
import jakarta.persistence.*;
import java.util.List;


@Entity
public class QnABoard {
    @Id @GeneratedValue
    private Long id;

    @OneToOne
    private Lecture lecture;

    @OneToMany(mappedBy = "board")
    private List<QnA> qnaList;
}