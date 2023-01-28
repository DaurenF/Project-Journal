package com.example.demo.service;

import com.example.demo.models.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface TasksService {
    Task createTask(Task task);

    List<Task> getTasks();

    void deleteTask(Long id);
}
