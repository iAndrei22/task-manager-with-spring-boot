package com.andrei.task.exception;

import java.util.UUID;

public class TaskNotFoundException extends RuntimeException {

    private final UUID id;

    public UUID getId() {
        return id;
    }

    public TaskNotFoundException(UUID id) {
        super(
                String.format("Task with ID '%s' doesn't exist.",id)
        );
        this.id=id;
    }
}
