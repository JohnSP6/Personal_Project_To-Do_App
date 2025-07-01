package com.jsper.To_Do_List_BE.Repositories;

import com.jsper.To_Do_List_BE.Models.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NoteRepository extends MongoRepository<Note, String> {

    List<Note> findAllByUserId(String userId);

}
