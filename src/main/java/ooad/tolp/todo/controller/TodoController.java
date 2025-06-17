package ooad.tolp.todo.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

import ooad.tolp.common.jwt.JwtUtil;
import ooad.tolp.todo.dto.TodoRequest;
import ooad.tolp.todo.dto.TodoResponse;
import ooad.tolp.todo.service.TodoService;
import ooad.tolp.user.domain.User;
import ooad.tolp.user.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    @PostMapping
    public ResponseEntity<String> addTodo(@RequestBody TodoRequest request, HttpServletRequest httpRequest) {
        String email = jwtUtil.extractEmail(jwtUtil.resolveToken(httpRequest));
        User user = userRepository.findByEmail(email).orElseThrow();
        todoService.addTodo(request, user);
        return ResponseEntity.ok("할일 등록 완료");
    }

    @PostMapping("/{id}/complete")
    public ResponseEntity<String> completeTodo(@PathVariable Long id) {
        todoService.completeTodo(id);
        return ResponseEntity.ok("완료 처리 완료");
    }

    @GetMapping("/my")
    public ResponseEntity<List<TodoResponse>> getMyTodos(HttpServletRequest request) {
        String email = jwtUtil.extractEmail(jwtUtil.resolveToken(request));
        User user = userRepository.findByEmail(email).orElseThrow();
        return ResponseEntity.ok(todoService.getAllTodos(user.getId()));
    }

    @GetMapping("/my/completed")
    public ResponseEntity<List<TodoResponse>> getMyCompletedTodos(HttpServletRequest request) {
        String email = jwtUtil.extractEmail(jwtUtil.resolveToken(request));
        User user = userRepository.findByEmail(email).orElseThrow();
        return ResponseEntity.ok(todoService.getCompletedTodos(user.getId()));
    }
}
