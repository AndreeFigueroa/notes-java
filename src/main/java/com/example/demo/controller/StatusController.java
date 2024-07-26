//package com.example.demo.controller;
//
//import com.example.demo.model.Category;
//import com.example.demo.model.Note;
//import com.example.demo.model.Status;
//import com.example.demo.service.CategoryService;
//import com.example.demo.service.StatusService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/status")
//public class StatusController {
//
//    @Autowired
//    private StatusService statusService;
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Status> getStatusById(@PathVariable Long id) {
//        Optional<Status> status = statusService.getById(id);
//        return status.map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @GetMapping("/all")
//    public ResponseEntity<Iterable<Status>> getAllStatus() {
//        Iterable<Status> status = statusService.getAll();
//        return ResponseEntity.ok(status);
//    }
//
//    @PostMapping("/{id}")
//    public ResponseEntity<Status> updateNote(@PathVariable Long id, @RequestBody Status statusData) {
//        statusService.save(statusData);
//        return ResponseEntity.ok(statusService.save(statusData));
//    }
//}
