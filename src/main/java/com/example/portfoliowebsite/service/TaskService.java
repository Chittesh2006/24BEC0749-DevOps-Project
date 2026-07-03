package com.example.portfoliowebsite.service;

import com.example.portfoliowebsite.model.Task;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskService {
    private final List<Task> portfolioInquiries = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Task createInquiry(Task inquiry) {
        inquiry.setId(idGenerator.getAndIncrement());
        if (inquiry.getStatus() == null) {
            inquiry.setStatus("PENDING");
        }
        portfolioInquiries.add(inquiry);
        System.out.println("New Portfolio Project Request Saved ID: " + inquiry.getId());
        return inquiry;
    }

    public List<Task> getAllInquiries() {
        return portfolioInquiries;
    }
}