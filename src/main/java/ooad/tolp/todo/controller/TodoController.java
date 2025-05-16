package ooad.tolp.todo.controller;

import lombok.RequiredArgsConstructor;

import ooad.tolp.todo.dto.TodoRequest;
import ooad.tolp.todo.dto.TodoResponse;
import ooad.tolp.todo.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<String> addTodo(@RequestBody TodoRequest request) {
        // TODO: 할일 등록 처리
        todoService.addTodo(request);
        return ResponseEntity.ok("할일 등록 완료");
    }

    @PostMapping("/{id}/complete")
    public ResponseEntity<String> completeTodo(@PathVariable Long id) {
        // TODO: 할일 완료 처리
        todoService.completeTodo(id);
        return ResponseEntity.ok("완료 처리 완료");
    }

    @GetMapping("/completed/{userId}")
    public ResponseEntity<String> getCompletedTodos(@PathVariable Long userId) {
        // TODO: 완료된 할일 조회
        List<TodoResponse> todos = todoService.getCompletedTodos(userId);
        return ResponseEntity.ok("완료된 목록 반환");
    }

    @GetMapping("/all/{userId}")
    public ResponseEntity<List<TodoResponse>> getAllTodos(@PathVariable Long userId){
        // TODO: 미완료 할일 조회
        List<TodoResponse> todos = todoService.getAllTodos(userId);
        return ResponseEntity.ok(todos);
    }
}
