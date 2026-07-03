package com.example.portfoliowebsite.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    private Long id;
    private String clientName;
    private String clientEmail;
    private String projectType;
    private String messageDescription;
    private String status; // e.g., PENDING, IN_PROGRESS, COMPLETED
}