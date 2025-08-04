package com.marakicode.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
public class OrderService {
    private PaymentService paymentService;

    public OrderService(PaymentService paymentService, int x) {

    }

    @Autowired
    public OrderService(@Qualifier("stripe") PaymentService paymentService) {
        this.paymentService = paymentService;
        System.out.println("OrderService Created!");
    }

    // Bean Life Cycle Hooks
    // @PostConstructor
    // @PreDestroy

    @PostConstruct
    public void init() {
        System.out.println("OrderService PostConstructor");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("OrderService PreDestroyed!");
    }

    public void placeOrder() {
        this.paymentService.processPayment(10);
    }
}
