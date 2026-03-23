package com.andrei.task.domain;

import com.andrei.task.domain.entity.TaskPriority;
import com.andrei.task.domain.entity.TaskStatus;

import java.time.LocalDate;

public record UpdateTaskRequest(
        String title,
        String description,
        LocalDate dueDate,
        TaskStatus status,
        TaskPriority priority
) {
}
