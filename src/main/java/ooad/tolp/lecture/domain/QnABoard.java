package ooad.tolp.lecture.domain;
import jakarta.persistence.*;
import ooad.tolp.qna.domain.QnA;

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