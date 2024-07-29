package com.example.demo.service;

import com.example.demo.model.Note;
import com.example.demo.model.Status;
import com.example.demo.repository.StatusRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class StatusServiceTest {
    @Mock
    private StatusRepository statusRepository;
    @InjectMocks
    private StatusService statusService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testGetById() {
        Status status1 = new Status();
        status1.setId(1L);
        status1.setName("status 1");

        when(statusRepository.findById(1L)).thenReturn(Optional.of(status1));

        Status result = statusService.getById(1L);
        assert(result.getId() == 1L);
        verify(statusRepository, times(1)).findById(1L);

    }
    @Test
    void testSave() {
        Status status1 = new Status();
        status1.setId(1L);
        status1.setName("status 1");

        when(statusRepository.save(status1)).thenReturn(status1);

        Status result = statusService.save(status1);
        assert(result.getId() == 1L);
        verify(statusRepository, times(1)).save(status1);
    }
    @Test
    void testFindAll() {
        Status status1 = new Status();
        status1.setId(1L);
        status1.setName("status 1");

        Status status2 = new Status();
        status2.setId(2L);
        status2.setName("status 2");

        List<Status> status = Arrays.asList(status1, status2);
        when(statusRepository.findAll()).thenReturn(status);

        List<Status> result = statusService.getAll();

        verify(statusRepository, times(1)).findAll();
        assertEquals("status 1", result.get(0).getName());
        assertEquals("status 2", result.get(1).getName());

    }
    @Test
    void testDelete() {
        doNothing().when(statusRepository).deleteById(1L);
        statusService.deleteById(1L);
        verify(statusRepository, times(1)).deleteById(1L);
    }

    @Test
    void testUpdate() {
        Status status1 = new Status();
        status1.setId(1L);
        status1.setName("status 1");

        when(statusRepository.findById(1L)).thenReturn(Optional.of(status1));
        when(statusRepository.save(status1)).thenReturn(status1);

        Status result = statusService.updateById(1L,status1);
        assert(result.getId() == 1L);
        assert(result.getName().equals("status 1"));
        verify(statusRepository, times(1)).save(status1);
        verify(statusRepository, times(1)).findById(1L);
    }

}
