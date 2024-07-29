package com.example.demo.controller;

import com.example.demo.model.Note;
import com.example.demo.service.NoteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@Tag(name = "Note", description = "Note api")
@RestController
@RequestMapping("/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        Optional<Note> note = noteService.getById(id);
        return ResponseEntity.ok(note.get());
    }

    @PostMapping("/save")
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        return ResponseEntity.ok(noteService.save(note));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id,@RequestBody Note noteData) {
        noteService.save(noteData);
        return ResponseEntity.ok(noteService.save(noteData));
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Note>> getAllNote() {
        Iterable<Note> note = noteService.getAll();
        return ResponseEntity.ok(note);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNoteById(@PathVariable Long id) {
        noteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
