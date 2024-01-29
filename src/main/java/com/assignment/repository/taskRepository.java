package com.assignment.repository;


import com.assignment.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface taskRepository extends JpaRepository<Task, Long> {


    List<Task> findAllByTitle(String title);
}
