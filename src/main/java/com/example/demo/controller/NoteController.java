//package com.example.demo.controller;
//
//import com.example.demo.dto.NoteDto;
//import com.example.demo.model.Note;
//import com.example.demo.service.NoteService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/notes")
//public class NoteController {
//    @Autowired
//    private NoteService noteService;
//
//    @GetMapping("/{id}")
//    public ResponseEntity<NoteDto> getNoteById(@PathVariable Long id) {
//        Optional<NoteDto> note = noteService.getById(id);
//        return note.map(ResponseEntity::ok)// Si la nota está presente, devuelve 200 OK con la nota.
//                .orElseGet(() -> ResponseEntity.notFound().build());// Si la nota no está presente, devuelve 404 Not Found.
//    }
//    @PostMapping("/")
//    public ResponseEntity<NoteDto> createNote(@RequestBody NoteDto noteData) {
//        noteService.save(noteData);
//        return ResponseEntity.ok(noteService.save(noteData));
//    }
//    @PostMapping("/{id}")
//    public ResponseEntity<NoteDto> updateNote(@PathVariable Long id,@RequestBody NoteDto noteData) {
//        noteService.save(noteData);
//        return ResponseEntity.ok(noteService.save(noteData));
//    }
//
//    @GetMapping("/all")
//    public ResponseEntity<Iterable<NoteDto>> getAllNote() {
//        Iterable<NoteDto> note = noteService.getAll();
//        return ResponseEntity.ok(note);
//    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteNoteById(@PathVariable Long id) {
//        noteService.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }
//
//}
