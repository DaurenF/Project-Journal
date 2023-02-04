package com.example.demo.service.task;

import com.example.demo.models.Task;
import com.example.demo.repository.TaskRepository;
import com.example.demo.service.task.TasksService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TasksServiceImpl implements TasksService {
    private final TaskRepository taskRepository;

    public TasksServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
