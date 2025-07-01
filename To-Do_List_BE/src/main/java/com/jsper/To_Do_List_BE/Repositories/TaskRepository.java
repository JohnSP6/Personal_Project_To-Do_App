package com.jsper.To_Do_List_BE.Repositories;

import com.jsper.To_Do_List_BE.Models.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {

    List<Task> findAllByUserId(String userId);

}
