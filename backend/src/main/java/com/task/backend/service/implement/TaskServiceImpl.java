package com.task.backend.service.implement;

import com.task.backend.entity.Task;
import com.task.backend.repository.TaskRepository;
import com.task.backend.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Override
    public Task create(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List <Task> read() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> readById(Long id) {
        return taskRepository.findById(id).stream().toList();
    }

    @Override
    public Task update(Long id, Task task) {
        return taskRepository.findById(id)
            .map(t -> {
                t.setTitle(task.getTitle());
                t.setDescription(task.getDescription());
                t.setDate_debut(task.getDate_debut());
                t.setDate_fin(task.getDate_fin());
                return taskRepository.save(t);
            }).orElseThrow(() -> new RuntimeException("tâche non trouvé"));
    }

    @Override
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

}
