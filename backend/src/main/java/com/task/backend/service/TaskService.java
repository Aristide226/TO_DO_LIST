package com.task.backend.service;

import com.task.backend.entity.Task;
import java.util.List;

public interface TaskService {
    Task create(Task task);
    List<Task> read();
    List<Task> readById(Long id);
    Task update(Long id, Task task);
    void delete(Long id);
}
