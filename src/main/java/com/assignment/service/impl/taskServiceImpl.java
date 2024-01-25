package com.assignment.service.impl;

import com.assignment.dto.TaskDTO;
import com.assignment.entity.Task;
import com.assignment.repository.taskRepository;
import com.assignment.service.taskService;
import com.assignment.util.MapperUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class taskServiceImpl implements taskService {

    private final taskRepository taskRepository;
    private final MapperUtil mapperUtil;

    public taskServiceImpl(com.assignment.repository.taskRepository taskRepository, MapperUtil mapperUtil) {
        this.taskRepository = taskRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(task -> mapperUtil.convert(task, new TaskDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public TaskDTO getTaskById(Long taskId) throws Exception{
        Task foundTask = taskRepository.findById(taskId)
                .orElseThrow(()-> new Exception("No Course Task found!"));
        return mapperUtil.convert(foundTask, new TaskDTO());
    }

    @Override
    public TaskDTO createTask(TaskDTO taskDTO) {
        return mapperUtil.convert(taskRepository.save(mapperUtil.convert(taskDTO, new Task())), new TaskDTO());
    }

    @Override
    public void updateTask(Long taskId, TaskDTO taskDTO) {
        Task task = mapperUtil.convert(taskDTO, new Task());
        taskRepository.findById(taskId).ifPresent(dbTask -> {
            dbTask.setTitle(task.getTitle());
            dbTask.setDescription(task.getDescription());
            dbTask.setCompleted(task.getCompleted());
            dbTask.setCreatedDate(task.getCreatedDate());
            dbTask.setCompletedDate(task.getCompletedDate());

            taskRepository.save(dbTask);
        });

    }
}
