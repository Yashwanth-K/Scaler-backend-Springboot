package com.scaler.springboot1.task;

import com.scaler.springboot1.task.dtos.CreateTaskDTO;

import java.util.Date;

public class TaskMapper {
    public CreateTaskDTO toCreateTaskDTO(String name, Date dueDate) {
        CreateTaskDTO createTaskDTO = new CreateTaskDTO();
        createTaskDTO.setName(name);
        createTaskDTO.setDueDate(dueDate);
        return createTaskDTO;
    }
}
