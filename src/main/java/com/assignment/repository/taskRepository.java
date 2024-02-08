package com.assignment.repository;


import com.assignment.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface taskRepository extends JpaRepository<Task, Long> {


    List<Task> findAllByTitle(String title);

    List<Task> findByDescription(String description);

    List<Task> findByCompleted(Boolean completed);

    List<Task> findByTitleEndsWith(String pattern);

    List<Task> findDistinctTop3ByTitle(String pattern);

    List<Task> findByCompletedDate(LocalDate completed);

    List<Task> findByCreatedDate(LocalDate created);
    List<Task> findByTitleOrDescription(String title, String description);

    List<Task> findByCreatedDateBetween(LocalDate startedDate, LocalDate endDate);

    List<Task> findByCompletedDateBetween(LocalDate startedDate, LocalDate endDate);



}
