package ooad.tolp.todo.domain;
import jakarta.persistence.*;
import ooad.tolp.user.domain.User;

import java.time.LocalDateTime;

@Entity
public class Todo {
    @Id @GeneratedValue
    private Long id;

    private String content;
    private Boolean completed = false;

    private LocalDateTime createdAt;

    @ManyToOne
    private User user;
}