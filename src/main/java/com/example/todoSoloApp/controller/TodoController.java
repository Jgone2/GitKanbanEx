package com.example.todoSoloApp.controller;

import com.example.todoSoloApp.dto.TodoDto;
import com.example.todoSoloApp.entity.Todo;
import com.example.todoSoloApp.mapper.TodoMapper;
import com.example.todoSoloApp.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/")
public class TodoController {

    private final TodoService todoService;
    private final TodoMapper mapper;

    @GetMapping("/main")
    public String main() {
        return "main";
    }

    @PostMapping("")
    public ResponseEntity postTodo(@Valid @RequestBody TodoDto.Post requestBody) {
        Todo todo = mapper.todoPostToTodo(requestBody);
        Todo createdTodo = todoService.createTodo(todo);
        return ResponseEntity.created(URI.create("/" + createdTodo.getId())).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity patchTodo(
            @PathVariable Long id,
            @Valid @RequestBody TodoDto.Patch requestBody) {
        Todo todo = mapper.todoPatchToTodo (requestBody);
        Todo updatedTodo = todoService.updateTodoById(id);
        return ResponseEntity.ok(mapper.todoToTodoResponse(updatedTodo));
    }

    @GetMapping("/{id}")
    public ResponseEntity getTodo(
            @PathVariable Long id) {
        Todo todo = todoService.findTodoById(id);
        return ResponseEntity.ok(mapper.todoToTodoResponse(todo));
    }

    @GetMapping("")
    public ResponseEntity getTodos() {
        return ResponseEntity.ok(mapper.todosToTodoResponses(todoService.findAllTodos()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTodo(
            @PathVariable Long id) {
        todoService.deleteTodoById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("")
    public ResponseEntity deleteTodos() {
        todoService.deleteAllTodos();
        return ResponseEntity.noContent().build();
    }
}
