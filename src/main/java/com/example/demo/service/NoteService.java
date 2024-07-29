package com.example.demo.service;

import com.example.demo.model.Note;
import com.example.demo.repository.NoteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public Optional<Note> getById(Long id) {
        return noteRepository.findById(id);
    }

    public Note save(Note note) {
        return noteRepository.save(note);
    }

    public void deleteById(Long id) {
        noteRepository.deleteById(id);
    }

    public List<Note> getAll() {
        List<Note> notes = noteRepository.findAll();
        return notes;
    }

    public Note updateById(Long id, Note noteData) {
        Optional<Note> noteOptional = noteRepository.findById(id);
        if (noteOptional.isPresent()) {
            Note note = noteOptional.get();
            note.setTitle(noteData.getTitle());
            note.setContent(noteData.getContent());
            return noteRepository.save(note);
        } else {
            throw new RuntimeException("Note not found");
        }
    }

}
