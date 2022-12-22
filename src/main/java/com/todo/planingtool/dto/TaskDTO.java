package com.todo.planingtool.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {

    private String taskInfo;
    private LocalDateTime creationDate;
    private boolean completionStatus;

}
