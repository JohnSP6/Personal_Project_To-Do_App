package com.jsper.To_Do_List_BE.Services;

import com.jsper.To_Do_List_BE.Models.Note;
import com.jsper.To_Do_List_BE.Repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public List<Note> getAllNotes(){
        return noteRepository.findAll();
    }

    public List<Note> getAllNotesByUserId(String userId){
        return noteRepository.findAllByUserId(userId);
    }

    public Optional<Note> getNoteById(String id){
        return noteRepository.findById(id);
    }

    public Note createNote(Note note){
        note.setCreatedDate(LocalDateTime.now());
        return noteRepository.save(note);
    }

    public void deleteNoteById(String id){
        noteRepository.deleteById(id);
    }

}
