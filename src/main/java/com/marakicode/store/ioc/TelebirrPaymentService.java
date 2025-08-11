package com.marakicode.store.ioc;

public class TelebirrPaymentService implements PaymentService {

    @Override
    public void processPayment(double amount) {
        System.out.println("TELEBIRR");
        System.out.println("Amount = " + amount);
    }

}
