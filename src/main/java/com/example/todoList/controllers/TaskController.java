package com.example.todoList.controllers;

import com.example.todoList.entities.Task;
import com.example.todoList.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> tasks = taskService.findAll();
        return ResponseEntity.ok().body(tasks);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(Long id){
        Task obj = taskService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Task> creatTask(@RequestBody Task task){
        Task obj = taskService.saveTask(task);
        return ResponseEntity.ok().body(obj);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@RequestBody Task task, @PathVariable Long id){
        Task obj = taskService.updateTask(task, id);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable Long id){
        taskService.deleteTaskById(id);
        return ResponseEntity.noContent().build();
    }
}
