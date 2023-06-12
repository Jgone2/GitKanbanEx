package com.example.todoSoloApp.mapper;

import com.example.todoSoloApp.dto.TodoDto;
import com.example.todoSoloApp.entity.Todo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TodoMapper {
    Todo todoPostToTodo(TodoDto.Post requestBody);
    Todo todoPatchToTodo (TodoDto.Patch requestBody);
    TodoDto.Response todoToTodoResponse(Todo todo);
    List<TodoDto.Response> todosToTodoResponses(List<Todo> todos);
}
