package com.example.demo.controller;

import com.example.demo.model.Status;
import com.example.demo.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private StatusService staticService;

    @PostMapping("/save")
    public Status createStatus(@RequestBody Status status) {
        return staticService.save(status);
    }

    @GetMapping("/all")
    public Iterable<Status> getAllStatus() {
        return staticService.getAll();
    }

    @GetMapping("/{id}")
    public Status getById(@PathVariable Long id) {
        return staticService.getById(id);
    }

}
