package com.example.todoList.services;

import com.example.todoList.entities.Task;
import com.example.todoList.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    public Task findById(Long id){
        return taskRepository.findById(id).get();
    }
    public Task saveTask(Task task){
        return taskRepository.save(task);
    }
    public void deleteTaskById (Long id){
        taskRepository.deleteById(id);
        System.out.println("task deletada");
    }
    public Task updateTask(Task task, Long id){
        Task obj = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task não encontrada"));
        obj.setTitle(task.getTitle());
        obj.setDescription(task.getDescription());
        obj.setStatus(task.getStatus());
        obj.setUser(task.getUser());
        obj.setCreatedAt(task.getCreatedAt());

        return taskRepository.save(obj);
    }
}
