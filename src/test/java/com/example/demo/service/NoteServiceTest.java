package com.example.demo.service;

import com.example.demo.model.Note;
import com.example.demo.repository.NoteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class NoteServiceTest {
    @Mock
    private NoteRepository noteRepository;
    @InjectMocks
    private NoteService noteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        noteRepository.deleteAll();
    }

    @Test
    void testGetById() {
        Note note1 = new Note();
        note1.setId(1L);
        note1.setTitle("Note 1");

        when(noteRepository.findById(1L)).thenReturn(Optional.of(note1));

        Optional<Note> result = noteService.getById(1L);
        assert(result.get().getId() == 1L);
        verify(noteRepository, times(1)).findById(1L);

    }
    @Test
    void testSaveNote() {
        Note note1 = new Note();
        note1.setId(1L);
        note1.setTitle("Note 1");

        when(noteRepository.save(note1)).thenReturn(note1);

        Note result = noteService.save(note1);
        assert(result.getId() == 1L);
        assert(result.getTitle().equals("Note 1"));
        verify(noteRepository, times(1)).save(note1);

    }

    @Test
    void testDeleteByIdNote() {
        doNothing().when(noteRepository).deleteById(1L);
        noteService.deleteById(1L);
        verify(noteRepository, times(1)).deleteById(1L);
    }

    @Test
    void testFindAllNotes() {
        Note note1 = new Note();
        note1.setId(1L);
        note1.setTitle("Note 1");

        Note note2 = new Note();
        note2.setId(2L);
        note2.setTitle("Note 2");

        List<Note> notes = Arrays.asList(note1, note2);
        when(noteRepository.findAll()).thenReturn(notes);

        noteRepository.findAll();

        assertEquals(2, notes.size());
        assertEquals("Note 1", notes.get(0).getTitle());
        assertEquals("Note 2", notes.get(1).getTitle());
        verify(noteRepository, times(1)).findAll();

    }
    @Test
    void testUpdate(){
        Note note1 = new Note();
        note1.setId(1L);
        note1.setTitle("Note 1");


        Note note2 = new Note();
        note2.setId(1L);
        note2.setTitle("Note 2");

        when(noteRepository.findById(1L)).thenReturn(Optional.of(note1));
        when(noteRepository.save(note2)).thenReturn(note2);

        Note result = noteService.updateById(1L, note2);
        assertEquals("Note 2", result.getTitle());
        verify(noteRepository, times(1)).findById(1L);
}
}
