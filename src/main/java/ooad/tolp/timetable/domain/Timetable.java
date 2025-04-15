package ooad.tolp.timetable.domain;
import jakarta.persistence.*;
import ooad.tolp.lecture.domain.Lecture;
import ooad.tolp.user.domain.User;

import java.util.List;

@Entity
public class Timetable {
    @Id @GeneratedValue
    private Long id;

    @OneToOne
    private User owner;

    @ManyToMany
    private List<Lecture> lectures;
}