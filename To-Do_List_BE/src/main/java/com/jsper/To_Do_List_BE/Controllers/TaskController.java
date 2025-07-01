package com.jsper.To_Do_List_BE.Controllers;

import com.jsper.To_Do_List_BE.Models.Task;
import com.jsper.To_Do_List_BE.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTask();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Task>> getAllTaskByUserId(@PathVariable String userId){
        List<Task> tasks = taskService.getAllTaskByUserId(userId);
        if(tasks.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tasks);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        Task createdTask = taskService.createTask(task);
        return ResponseEntity.ok(createdTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable String id){
        taskService.deleteTaskById(id);
        return ResponseEntity.noContent().build();
    }

}
