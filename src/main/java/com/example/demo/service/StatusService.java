package com.example.demo.service;

import com.example.demo.model.Status;
import com.example.demo.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {
    @Autowired
    private StatusRepository statusRepository;

    public List<Status> getAll() {
        return statusRepository.findAll();
    }

    public Status save(Status status) {
        return statusRepository.save(status);
    }

    public void deleteById(Long id) {
        statusRepository.deleteById(id);
    }

    public Status getById(Long id) {
        return statusRepository.findById(id).orElse(null);
    }

    public Status updateById(Long id, Status statusData) {
        Status status = statusRepository.findById(id).orElse(null);
        if (status != null) {
            status.setName(statusData.getName());
            return statusRepository.save(status);
        } else {
            throw new RuntimeException("Status not found");
        }
    }

}
