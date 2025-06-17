package ooad.tolp.todo.service;

import lombok.RequiredArgsConstructor;

import ooad.tolp.todo.domain.Todo;
import ooad.tolp.todo.dto.TodoRequest;
import ooad.tolp.todo.dto.TodoResponse;
import ooad.tolp.todo.repository.TodoRepository;
import ooad.tolp.user.domain.User;
import ooad.tolp.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public void addTodo(TodoRequest request, User user) {
        Todo todo = new Todo();
        todo.setContent(request.getContent());
        todo.setCompleted(false);
        todo.setUser(user);
        todo.setCreatedAt(LocalDateTime.now());
        todoRepository.save(todo);
    }

    public void completeTodo(Long todoId) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new IllegalArgumentException("할 일을 찾을 수 없습니다."));
        todo.setCompleted(true);
        todoRepository.save(todo);
    }

    public List<TodoResponse> getCompletedTodos(Long userId) {
        return todoRepository.findByUserIdAndCompletedTrue(userId).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public List<TodoResponse> getAllTodos(Long userId) {
        return todoRepository.findByUserIdAndCompletedFalse(userId).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private TodoResponse toResponse(Todo todo) {
        TodoResponse response = new TodoResponse();
        response.setId(todo.getId());
        response.setContent(todo.getContent());
        response.setCompleted(todo.getCompleted());
        return response;
    }
}
