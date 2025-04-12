package ooad.tolp.entity;
import jakarta.persistence.*;
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