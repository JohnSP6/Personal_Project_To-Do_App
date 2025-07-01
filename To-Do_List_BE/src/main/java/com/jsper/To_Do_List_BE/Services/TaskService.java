package com.jsper.To_Do_List_BE.Services;

import com.jsper.To_Do_List_BE.Models.Recurrence;
import com.jsper.To_Do_List_BE.Models.Task;
import com.jsper.To_Do_List_BE.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }

    public Optional<Task> getAllTaskById(String id){
        return taskRepository.findById(id);
    }

    public List<Task> getAllTaskByUserId(String userId){
        return taskRepository.findAllByUserId(userId);
    }

    public Task createTask(Task task){
        Recurrence recurrence = new Recurrence();
        LocalDate today = LocalDate.now();

        //recurrence.setInterval("One-Time");
        recurrence.setNextDueDate(today.plusDays(1));

        //task.setPriority(3);
        task.setTaskStatus("Pending");
        task.setCreatedDate(LocalDateTime.now());
        task.setRecurrence(recurrence);

        return taskRepository.save(task);
    }

    public void deleteTaskById(String id){
        taskRepository.deleteById(id);
    }

}
