package com.jsper.To_Do_List_BE.Controllers;

import com.jsper.To_Do_List_BE.Models.Note;
import com.jsper.To_Do_List_BE.Services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping
    private List<Note> getAllNotes(){
        return noteService.getAllNotes();
    }

    @GetMapping("/{userId}")
    private ResponseEntity<List<Note>> getAllNotesByUserId(@PathVariable String userId){
        List<Note> notes = noteService.getAllNotesByUserId(userId);
        if(notes.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(notes);
    }

    @PostMapping
    private ResponseEntity<Note> createNote(@RequestBody Note note){
        Note createdNote = noteService.createNote(note);
        return ResponseEntity.ok(createdNote);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteNoteById(@PathVariable String id){
        noteService.deleteNoteById(id);
        return ResponseEntity.noContent().build();
    }
}
