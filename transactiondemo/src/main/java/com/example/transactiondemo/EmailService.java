package com.example.transactiondemo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmailService {
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void sendEmail(String to) {
        System.out.println("Sending email to " + to);
        try {
            Thread.sleep(6000); // Simulate delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        throw new RuntimeException("Email sending failed!");
    }
}
