package com.andrei.task.domain.entity;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="tasks")
public class Task {

    public Task() {
    }

    public Task(UUID id, String title, String description, LocalDate dueDate, TaskStatus status, TaskPriority priority, Instant created, Instant updated) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
        this.priority = priority;
        this.created = created;
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", status=" + status +
                ", priority=" + priority +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public Instant getCreated() {
        return created;
    }

    public Instant getUpdated() {
        return updated;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public void setUpdated(Instant updated) {
        this.updated = updated;
    }

    // The task's unique identifier. Generated automatically by JPA.
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        @Column(name = "id", updatable = false, nullable = false)
        private UUID id;

    //The title of the task. A maximum length of 255 characters.
        @Column(name = "title", nullable = false)
        private String title;

    //A description of the task. A maximum length of 1000 characters.
        @Column(name = "description", length = 1000)
        private String description;

    //The date the task is due.
        @Column(name = "due_date")
        private LocalDate dueDate;

    //The status of the task: is it open or complete?
        @Enumerated(EnumType.STRING)
        @Column(name = "status", nullable = false)
        private TaskStatus status;

    //The task's priority: how important is the task - high, medium, or low?
        @Enumerated(EnumType.STRING)
        @Column(name = "priority", nullable = false)
        private TaskPriority priority;

    // The date and time the task was created.
        @Column(name = "created", nullable = false, updatable = false)
        private Instant created;

    // The date and time the task was last updated.
        @Column(name = "updated", nullable = false)
        private Instant updated;
}
