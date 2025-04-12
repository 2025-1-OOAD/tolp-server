package ooad.tolp.service;

import ooad.tolp.dto.Request.TodoRequest;
import ooad.tolp.dto.Response.TodoResponse;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class TodoService {

    public void addTodo(TodoRequest request) {
        // TODO: 할일 등록 처리
    }

    public void completeTodo(Long todoId) {
        // TODO: 할일 완료 처리
    }

    public void getCompletedTodos(Long userId) {
        // TODO: 완료된 할일 목록 조회 처리
    }

    public void getAllTodos(Long userId) {
        // TODO: 미완료 할일 목록 조회 처리
    }

}
