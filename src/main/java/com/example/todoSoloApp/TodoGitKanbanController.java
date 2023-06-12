package com.example.todoSoloApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/git-kanban")
public class TodoGitKanbanController {

    @GetMapping("/todo")
    public String helloWorld() {
        return "To-do Application !";
    }

    @GetMapping("/doit")
    public String icando() {
        return "I can do it !";
    }
}
