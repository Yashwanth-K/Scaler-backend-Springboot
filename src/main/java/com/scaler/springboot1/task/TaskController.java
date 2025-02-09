package com.scaler.springboot1.task;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    List<Task> taskList= new ArrayList<>();
    private Integer nextTaskId = 1;

    @GetMapping("")
    public List<Task> getTasks() {
        return taskList;
    }

    @PostMapping("")
    public Task addTask(@RequestBody Task task) {
        task.setId(nextTaskId++);
        taskList.add(task);
        return task;
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Integer id) {
        Task taskFound = taskList.stream().filter(task -> task.getId().equals(id)).findFirst().orElse(null);
        return taskFound;
    }

}
