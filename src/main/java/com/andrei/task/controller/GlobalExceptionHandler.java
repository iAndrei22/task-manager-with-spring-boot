package com.andrei.task.controller;

import com.andrei.task.domain.dto.ErrorDto;
import com.andrei.task.exception.TaskNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.UUID;

@ControllerAdvice
public class GlobalExceptionHandler {
    public ResponseEntity<ErrorDto> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult().getFieldErrors().stream()
                .findFirst()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .orElse("Validation failed.");
                // Create an ErrorResponseDto using the error message.
                ErrorDto errorDto = new ErrorDto(errorMessage);
                // Return the ErrorResponseDto in the response body with an HTTP 400 BAD REQUEST.
                        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ErrorDto> handleTaskNotFoundException(TaskNotFoundException ex) {
        UUID taskNotFoundById = ex.getId();
        String errorMessage = String.format("Task with ID '%s' not found", taskNotFoundById);
        ErrorDto errorDto = new ErrorDto(errorMessage);
        return new ResponseEntity<>(errorDto,HttpStatus.BAD_REQUEST);
                }

}


