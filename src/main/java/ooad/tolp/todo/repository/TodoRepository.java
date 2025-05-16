package ooad.tolp.todo.repository;

import ooad.tolp.todo.domain.Todo;
import ooad.tolp.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByUserIdAndCompletedFalse(Long userId);
    List<Todo> findByUserIdAndCompletedTrue(Long userId);
}
