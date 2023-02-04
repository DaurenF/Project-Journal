package com.example.demo.service.task;

import com.example.demo.models.Task;

import java.util.List;

public interface TasksService {
    Task createTask(Task task);

    List<Task> getTasks();

    void deleteTask(Long id);
}
