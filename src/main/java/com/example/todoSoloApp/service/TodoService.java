package com.example.todoSoloApp.service;

import com.example.todoSoloApp.entity.Todo;
import com.example.todoSoloApp.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    public Todo updateTodoById(Long id) {
        findVerifiedTOdo(id).setCompleted(!findVerifiedTOdo(id).isCompleted());

        return todoRepository.save(findVerifiedTOdo(id));
    }

    @Transactional(readOnly = true)
    public Todo findTodoById(Long id) {
        return findVerifiedTOdo(id);
    }

    @Transactional(readOnly = true)
    public List<Todo> findAllTodos() {
        return todoRepository.findAll();
    }

    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }

    public void deleteAllTodos() {
        todoRepository.deleteAll();
    }

    @Transactional(readOnly = true)
    public Todo findVerifiedTOdo(long id) {
        return todoRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }
}
