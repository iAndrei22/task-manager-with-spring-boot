package com.andrei.task.domain;

import com.andrei.task.domain.entity.TaskPriority;

import java.time.LocalDate;

public record CreateTaskRequest(
    String title,
    String description,
    LocalDate dueDate,
    TaskPriority priority) {
}
