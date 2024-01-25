package com.assignment.dto;


import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaskDTO {


    private Long id;

    private String title;

    private String description;

    private Boolean completed;

    private LocalDateTime createdDate;

    private LocalDateTime completedDate;


}

