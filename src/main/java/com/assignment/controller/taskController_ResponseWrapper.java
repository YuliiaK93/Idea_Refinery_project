package com.assignment.controller;

import com.assignment.dto.ResponseWrapper;
import com.assignment.service.taskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks/api/v3")
public class taskController_ResponseWrapper {

    private final taskService taskService;

    public taskController_ResponseWrapper(com.assignment.service.taskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getAllTasks(){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Version", "Assignment.V3")
                .body(new ResponseWrapper("tasks successfully retrieved", taskService.getAllTasks() ));

    }
    @GetMapping("{id}")
    public ResponseEntity<ResponseWrapper> getTaskById(@PathVariable("id") long taskId) throws Exception {
        return ResponseEntity.ok(new ResponseWrapper
                ("task: " + taskId + " retrieved", taskService.getTaskById(taskId)));

    }

}
