package com.example.demo.service;

import com.example.demo.dto.StatusDto;
import com.example.demo.model.Note;
import com.example.demo.model.Status;
import com.example.demo.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatusService {
    @Autowired
    private StatusRepository statusRepository;

    public Optional<Status> getById(Long id) {
        return statusRepository.findById(id);
    }
    public Status save(Status status) {
        return (Status) statusRepository.save(status);
    }
    public void deleteById(Long id) {
        statusRepository.deleteById(id);
    }
    public Iterable<Status> getAll() {

        return statusRepository.findAll();
    }
    public void updateById(Long id, Status status) {
        statusRepository.save(status);
    }
}
