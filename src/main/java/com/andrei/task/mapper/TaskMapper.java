package com.andrei.task.mapper;

import com.andrei.task.domain.CreateTaskRequest;
import com.andrei.task.domain.UpdateTaskRequest;
import com.andrei.task.domain.dto.CreateTaskRequestDto;
import com.andrei.task.domain.dto.TaskDto;
import com.andrei.task.domain.dto.UpdateTaskRequestDto;
import com.andrei.task.domain.entity.Task;

public interface TaskMapper {

    CreateTaskRequest fromDto(CreateTaskRequestDto dto);
    UpdateTaskRequest fromDto(UpdateTaskRequestDto dto);
    TaskDto toDto(Task task);

}
