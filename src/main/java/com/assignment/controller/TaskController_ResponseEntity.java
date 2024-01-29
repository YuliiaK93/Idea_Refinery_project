package com.assignment.controller;

import com.assignment.dto.TaskDTO;
import com.assignment.service.taskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses/api/v2")
public class TaskController_ResponseEntity {

    private final taskService taskService;

    public TaskController_ResponseEntity(com.assignment.service.taskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAllTasks(){
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .header("Version", "Assignment.V2")
                .header("Operation", "Get List")
                .body(taskService.getAllTasks());

    }

    @GetMapping("{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable("id") long taskId) throws Exception {
        return ResponseEntity.ok(taskService.getTaskById(taskId));
    }
    @GetMapping("title/{name}")
    public ResponseEntity<List<TaskDTO>> getTaskByTitle(@PathVariable("name") String title){
        return ResponseEntity.ok(taskService.getTasksByTitle(title));
    }

    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO task){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Operation", "Create")
                .body(taskService.createTask(task));
    }

}
