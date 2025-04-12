package ooad.tolp.controller;

import ooad.tolp.dto.TodoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    @PostMapping
    public ResponseEntity<String> addTodo(@RequestBody TodoRequest request) {
        // TODO: 할일 등록 처리
        return ResponseEntity.ok("할일 등록 완료");
    }

    @PostMapping("/{id}/complete")
    public ResponseEntity<String> completeTodo(@PathVariable Long id) {
        // TODO: 할일 완료 처리
        return ResponseEntity.ok("완료 처리 완료");
    }

    @GetMapping("/completed/{userId}")
    public ResponseEntity<String> getCompletedTodos(@PathVariable Long userId) {
        // TODO: 완료된 할일 조회
        return ResponseEntity.ok("완료된 목록 반환");
    }
}
