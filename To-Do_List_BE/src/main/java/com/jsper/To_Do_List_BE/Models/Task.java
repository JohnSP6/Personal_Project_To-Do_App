package com.jsper.To_Do_List_BE.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "tasks")
public class Task {

    @Id
    private String id;

    @Indexed
    private String userId;

    private String taskName;
    private String taskDesc;

    @Indexed
    private int priority;

    private Recurrence recurrence;
    private String[] tags;

    @Indexed
    private String taskStatus;

    private LocalDateTime createdDate;

}
