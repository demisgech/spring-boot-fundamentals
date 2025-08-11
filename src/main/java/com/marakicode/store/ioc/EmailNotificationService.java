package com.marakicode.store.ioc;

import org.springframework.stereotype.Service;

// @Service("email")
public class EmailNotificationService implements NotificationService {

    @Override
    public void send(String message) {
        System.out.println("Sending E-mail ...");
        System.out.println("Message: " + message);
    }

}
