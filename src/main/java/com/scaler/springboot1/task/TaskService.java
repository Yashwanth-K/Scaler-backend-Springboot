package com.scaler.springboot1.task;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TaskService {
    List<Task> taskList = new ArrayList<>();
    private Integer nextTaskId = 1;

//    get all tasks
    public List<Task> getTasks() {
        return taskList;
    }

//    add new task
    public Task addTask(String name, Date dueDate) {
        Task task =new Task(nextTaskId++,name,dueDate,false);
        taskList.add(task);
        return task;
    }
//    get task by id
    public Task getTaskById(Integer id) {
        return taskList.stream().filter(task -> task.getId().equals(id)).findFirst().orElseThrow(() -> new TaskNotFoundException(id));
    }
//    update task
    public Task updateTask(Integer id,Date dueDate,Boolean completed) {
        Task task = getTaskById(id);

        if (dueDate != null) {
            task.setDueDate(dueDate);
        }
        if (completed != null) {
            task.setCompleted(completed);
        }
        return task;
    }
//    delete task
    public void deleteTask(Integer id) {
        Task task = getTaskById(id);
        taskList.remove(task);
    }
//class to handle error when task is not found. Here we are having TaskNotFoundException class withing TaskService class
    public static class TaskNotFoundException extends RuntimeException {
        public TaskNotFoundException(Integer id) {
            super("Task with id " + id + " not found");
        }
    }

}
