package com.scaler.springboot1.task.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class UpdateTaskDTO {
    Date dueDate;
    Boolean completed;
}
