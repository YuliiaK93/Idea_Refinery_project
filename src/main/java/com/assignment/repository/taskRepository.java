package com.assignment.repository;


import com.assignment.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface taskRepository extends JpaRepository<Task, Long> {



}
