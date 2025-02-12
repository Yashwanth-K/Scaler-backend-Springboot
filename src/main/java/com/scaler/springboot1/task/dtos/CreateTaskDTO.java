package com.scaler.springboot1.task.dtos;

import com.scaler.springboot1.task.TaskService;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Data
public class CreateTaskDTO {
    String name;
    Date dueDate;

}










