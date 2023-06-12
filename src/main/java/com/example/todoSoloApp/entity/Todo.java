package com.example.todoSoloApp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false, unique = false, updatable = true)
    private String title;

    @Column(nullable = false, unique = true, updatable = false)
    private int todoOrder;

    @Column(nullable = false, unique = false, updatable = true)
    private boolean completed;

    public Todo(Long id) {
        this.id = id;
    }

    public Todo(String title, int todoOrder, boolean completed) {
        this.title = title;
        this.todoOrder = todoOrder;
        this.completed = completed;
    }
}
