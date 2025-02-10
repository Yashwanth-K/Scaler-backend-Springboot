package com.scaler.springboot1.task;

import com.scaler.springboot1.task.dtos.CreateTaskDTO;
import com.scaler.springboot1.task.dtos.UpdateTaskDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("")
    ResponseEntity<List<Task>> getTasks() {
        return ResponseEntity.ok(taskService.getTasks());
    }
    @PostMapping("")
    ResponseEntity<Task> createTask(@RequestBody CreateTaskDTO createTaskDTO) {
        return ResponseEntity.ok(taskService.addTask(createTaskDTO.getName(), createTaskDTO.getDueDate()));
    }
    @GetMapping("/{id}")
    ResponseEntity<Task> getTaskById(@PathVariable Integer id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

//     Todo1: implement Update Task  PATCH
    @PatchMapping("/{id}")
    ResponseEntity<Task> updateTask(@PathVariable Integer id, @RequestBody UpdateTaskDTO updateTaskDTO) {
        return ResponseEntity.ok(taskService.updateTask(id, updateTaskDTO.getDueDate(), updateTaskDTO.getCompleted()));
    }

//     Todo2: implement Delete Task - DELETE
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteTask(@PathVariable Integer id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
//        what does build() do?
    }
//     Todo3 - handle exception for IllegalArgumentException (due date, name)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgumentException(IllegalArgumentException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

//     Todo4 - in error responses, also send the error message in the response body
    @ExceptionHandler(TaskService.TaskNotFoundException.class)
    public ResponseEntity<String> handleTaskNotFoundException(TaskService.TaskNotFoundException ex) {
//        Map<String, String> errorResponse = new HashMap<>();
//        errorResponse.put("error-notask", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
//     Todo5: create a ResponseBodyDTO - only return name, dueDate, completed




}
