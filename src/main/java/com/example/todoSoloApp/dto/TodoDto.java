package com.example.todoSoloApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

public class TodoDto {
    @Getter
    @AllArgsConstructor
    public static class Post {
        @NotBlank
        private String title;
        private int todoOrder;
        private boolean completed;
    }

    @Getter
    @AllArgsConstructor
    public static class Patch {
        private Long id;

        @NotBlank(message = "title은 공백이 아니어야 합니다.")
        private String title;

        @NotBlank(message = "todoOrder는 공백이 아니어야 합니다.")
        private int todoOrder;

        @NotBlank(message = "completed는 공백이 아니어야 합니다.")
        private boolean completed;
    }

    @Getter
    @AllArgsConstructor
    public static class Response {
        private Long id;
        private String title;
        private int todoOrder;
        private boolean completed;
    }
}
