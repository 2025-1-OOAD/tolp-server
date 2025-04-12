package ooad.tolp.entity;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Todo {
    @Id @GeneratedValue
    private Long id;

    private String content;
    private Boolean completed;

    @ManyToOne
    private User user;
}