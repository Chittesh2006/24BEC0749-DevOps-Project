package com.example.portfoliowebsite.controller;

import com.example.portfoliowebsite.model.Task;
import com.example.portfoliowebsite.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/submit")
    public ResponseEntity<Task> submitProjectRequest(@RequestBody Task inquiry) {
        Task savedInquiry = taskService.createInquiry(inquiry);
        return ResponseEntity.ok(savedInquiry);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Task>> listInquiries() {
        return ResponseEntity.ok(taskService.getAllInquiries());
    }
}