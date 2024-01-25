package com.assignment;

import com.assignment.entity.Task;
import com.assignment.repository.taskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;


@SpringBootApplication
public class AssignmentApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext =
                SpringApplication.run(AssignmentApp.class, args);
        taskRepository taskRepository= configurableApplicationContext.getBean(taskRepository.class);

        Task task1 = new Task(1l, "Task 1", "Create a user story", true, LocalDate.of(2024,02,02), LocalDate.of(2024,03,04));
        Task task2 = new Task(2l, "Task 2", "Create a Backlog", true, LocalDate.of(2024,03,11), LocalDate.of(2024,04,14));
        Task task3 = new Task(3l, "Task 3", "Follow SDLC structure", false, LocalDate.of(2025,01,01), LocalDate.of(2026,07,15));

        taskRepository.save(task1);
        taskRepository.save(task2);
        taskRepository.save(task3);
    }

    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }

}
