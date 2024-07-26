package com.example.demo.service;

import com.example.demo.dto.NoteDto;
import com.example.demo.model.Note;
import com.example.demo.model.Category;
import com.example.demo.model.Status;
import com.example.demo.repository.NoteRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.StatusRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private StatusRepository statusRepository;

    public Optional<NoteDto> getById(Long id) {
        return noteRepository.findById(id).map(this::convertToDTO);
    }

    public NoteDto save(NoteDto noteDTO) {
        Note note = convertToEntity(noteDTO);
        return convertToDTO(noteRepository.save(note));
    }

    public void deleteById(Long id) {
        noteRepository.deleteById(id);
    }

    public List<NoteDto> getAll() {
        return noteRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public NoteDto updateById(Long id, NoteDto noteDTO) {
        Optional<Note> noteOptional = noteRepository.findById(id);
        if (noteOptional.isPresent()) {
            Note note = noteOptional.get();
            note.setTitle(noteDTO.getTitle());
            note.setContent(noteDTO.getContent());
            //note.setCategory(categoryRepository.findById(noteDTO.getCategoryId()).orElse(null));
            //note.setStatus(statusRepository.findById(noteDTO.getStatusId()).orElse(null));
            return convertToDTO(noteRepository.save(note));
        } else {
            throw new RuntimeException("Note not found");
        }
    }

    private NoteDto convertToDTO(Note note) {
        return new NoteDto(
                note.getId(),
                note.getTitle(),
                note.getContent()

                //note.getCategory() != null ? note.getCategory().getId() : null,
                //note.getStatus() != null ? note.getStatus().getId() : null
        );
    }

    private Note convertToEntity(NoteDto noteDTO) {
        Note note = new Note();
        note.setId(noteDTO.getId());
        note.setTitle(noteDTO.getTitle());
        note.setContent(noteDTO.getContent());
        //note.setCategory(categoryRepository.findById(noteDTO.getCategoryId()).orElse(null));
        //note.setStatus(statusRepository.findById(noteDTO.getStatusId()).orElse(null));
        return note;
    }
}
