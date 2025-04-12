package ooad.tolp.entity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

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