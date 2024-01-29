package com.assignment.service;

import com.assignment.dto.TaskDTO;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;
@ComponentScan

public interface taskService {

    List<TaskDTO> getAllTasks();
    TaskDTO getTaskById(Long taskId) throws Exception;

    TaskDTO createTask(TaskDTO task);

    void updateTask(Long taskId, TaskDTO task);

    List<TaskDTO> getTasksByTitle(String title);

    void deleteTaskById(Long taskId);
}
