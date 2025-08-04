package com.marakicode.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
    @Value("${payment-gateway:paypal}")
    private String paymentGateway;

    @Value("${notification-service:sms}")
    private String notificationService;

    @Bean
    public PaymentService stripe() {
        return new StripePaymentService();
    }

    @Bean
    public PaymentService paypal() {
        return new PaypalPaymentService();
    }

    // Bean Scopes
    // Singleton -> Default (single instance of Beans)
    // Prototype
    // Request
    // Session

    @Bean
    // Lazy initialization
    // @Lazy
    // Bean scope
    // @Scope("prototype")
    public OrderService orderService() {
        if (paymentGateway.equalsIgnoreCase("stripe"))
            return new OrderService(stripe());
        return new OrderService(paypal());
    }

    @Bean
    public NotificationService email() {
        return new EmailNotificationService();
    }

    public NotificationService sms() {
        return new SMSNotificationService();
    }

    @Bean
    public NotificationManager notificationManager() {
        if (notificationService.equalsIgnoreCase("email"))
            return new NotificationManager(email());
        return new NotificationManager(sms());
    }
}
