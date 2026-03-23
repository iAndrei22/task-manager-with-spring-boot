package com.andrei.task.service;

import com.andrei.task.TaskApplication;
import com.andrei.task.domain.CreateTaskRequest;
import com.andrei.task.domain.UpdateTaskRequest;
import com.andrei.task.domain.entity.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    Task createTask(CreateTaskRequest request);

    List<Task> listTasks();

    Task updateTask(UUID taskId, UpdateTaskRequest request);

    void deleteTask(UUID taskId);
}
