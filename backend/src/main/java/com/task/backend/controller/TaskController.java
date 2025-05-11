package com.task.backend.controller;

import com.task.backend.entity.Task;
import com.task.backend.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/tasks")
@RequiredArgsConstructor

public class TaskController {
    private final TaskService taskService;

    @PostMapping
    public Task create(@RequestBody Task task) {
        return taskService.create(task);
    }

    @GetMapping("/get")
    public List<Task> read () {
        return taskService.read();
    }

    @GetMapping("/{id}")
    public List<Task> readById(@PathVariable Long id) {
        return taskService.readById(id);
    }
    
    @PutMapping("/{id}")
    public Task update(@PathVariable Long id, @RequestBody Task task) {
        return taskService.update(id, task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        taskService.delete(id);
    }
}
