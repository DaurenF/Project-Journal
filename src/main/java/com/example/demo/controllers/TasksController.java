package com.example.demo.controllers;

import com.example.demo.models.Task;
import com.example.demo.service.task.TasksServiceImpl;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.ok(tasksService.createTask(task));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Task>> getTasks() {
        return ResponseEntity.ok(tasksService.getTasks());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        tasksService.deleteTask(id);
        return ResponseEntity.ok("Object deleted");
    }
}
