
package com.assignment.controller;

import com.assignment.dto.TaskDTO;
import com.assignment.service.taskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/tasks/api/v1")
    public class taskController {

        private final taskService taskService;

        public taskController(taskService taskService) {
            this.taskService = taskService;
        }


        @GetMapping
        public List<TaskDTO> getAllTasks(){
            return taskService.getAllTasks();

        }
        @GetMapping("{id}")
        public TaskDTO getTaskById(@PathVariable("id") long taskId) throws Exception{
            return taskService.getTaskById(taskId);

        }

        @PostMapping
        public TaskDTO createTask(@RequestBody TaskDTO task){
            return taskService.createTask(task);
        }

        @PutMapping("{id}")
        public void updateTask(@PathVariable("id") long taskId, @RequestBody TaskDTO task){
            taskService.updateTask(taskId, task);

        }
    }



