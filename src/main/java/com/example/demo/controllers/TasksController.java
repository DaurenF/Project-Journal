package com.example.demo.controllers;

import com.example.demo.models.Task;
import com.example.demo.service.TasksServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TasksController {

    private final TasksServiceImpl tasksService;

    public TasksController(TasksServiceImpl tasksService) {
        this.tasksService = tasksService;
    }


    @PostMapping("/create")
    public Task createTask(@RequestBody Task task) {
        return tasksService.createTask(task);
    }

    @GetMapping("/all")
    public List<Task> getTasks() {
        return tasksService.getTasks();
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        tasksService.deleteTask(id);
    }
}
