package com.andrei.task.controller;

import com.andrei.task.domain.CreateTaskRequest;
import com.andrei.task.domain.UpdateTaskRequest;
import com.andrei.task.domain.dto.CreateTaskRequestDto;
import com.andrei.task.domain.dto.TaskDto;
import com.andrei.task.domain.dto.UpdateTaskRequestDto;
import com.andrei.task.domain.entity.Task;
import com.andrei.task.mapper.TaskMapper;
import com.andrei.task.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path="/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @PostMapping
    public ResponseEntity<TaskDto> createTask(
            @Valid @RequestBody CreateTaskRequestDto createTaskRequestDto) {
        // Map the CreateTaskRequestDto to a CreateTaskRequest.
        CreateTaskRequest taskToCreate = taskMapper.fromDto(
                createTaskRequestDto
        );
        // Call createTask on the TaskService,
        // passing the CreateTaskRequest as an argument.
        Task createdTask = taskService.createTask(taskToCreate);
        // Map the newly created Task object into a TaskDto.
        TaskDto createdTaskDto = taskMapper.toDto(createdTask);
        // Return the TaskDto object to the caller with an HTTP 201 CREATED.
        return new ResponseEntity<>(createdTaskDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> listTask() {
        List<Task> tasks = taskService.listTasks();
        List<TaskDto> taskDtos = tasks.stream().map(taskMapper::toDto).toList();
        return ResponseEntity.ok(taskDtos);

    }

    @PutMapping(path = "/{taskId}")
    public ResponseEntity<TaskDto> updateTask(
            @PathVariable UUID taskId,
            @Valid @RequestBody UpdateTaskRequestDto updateTaskRequestDto) {
        // Map the UpdateTaskRequestDto to an UpdateTaskRequest.
        UpdateTaskRequest updateTaskRequest = taskMapper.fromDto(
                updateTaskRequestDto
        );
        // Pass the UpdateTaskRequest to the TaskService's updateTask method.
        Task updatedTask = taskService.updateTask(taskId, updateTaskRequest);
        // Map the Task to a TaskDto.
        TaskDto taskMapperDto = taskMapper.toDto(updatedTask);
        // Return the TaskDto with an HTTP 200.
        return ResponseEntity.ok(taskMapperDto);
    }

    @DeleteMapping(path = "{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable UUID taskId){
        taskService.deleteTask(taskId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
