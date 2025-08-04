package com.marakicode.store.exercise;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("email-service")
@Primary
public class EmailNotificationService implements NotificationService {
    @Value("${mail-server.host}")
    private String host;

    @Value("${mail-server.port}")
    private int port;

    @Override
    public void send(String message, String recipientEmail) {
        System.out.println("Sending email for " + recipientEmail);
        System.out.println(message);
        System.out.println("Host: " + host);
        System.out.println("Port: " + port);
    }

}
