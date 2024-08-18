package com.smartbank.notificationservice.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

public interface EmailService {

    @Async
    public CompletableFuture<Void> sendEmail(String to, String subject, String text);

}