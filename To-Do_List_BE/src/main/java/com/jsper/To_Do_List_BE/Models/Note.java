package com.jsper.To_Do_List_BE.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "notes")
public class Note {

    @Id
    private String id;

    @Indexed
    private String userId;

    private String noteTitle;
    private String noteContent;
    private LocalDateTime createdDate;

}
