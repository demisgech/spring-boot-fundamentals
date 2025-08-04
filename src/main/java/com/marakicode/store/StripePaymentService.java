package com.marakicode.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("stripe")
@Primary
public class StripePaymentService implements PaymentService {
    @Value("${stripe.apiUrl}")
    private String apiUrl;

    // Default value incase stripe.enabled is not defined in the
    // application.properties file
    @Value("${stripe.enabled:false}")
    private boolean enabled;

    @Value("${stripe.timeout:3000}")
    private int timeout;

    @Value("${stripe.supported-currencies}")
    private List<String> supportedCurrencies;

    @Override
    public void processPayment(double amount) {
        System.out.println("STRIPE");
        System.out.println("apiUrl: " + apiUrl);
        System.out.println("enabled: " + enabled);
        System.out.println("timeout: " + timeout);
        System.out.println("supported-currencies: " + supportedCurrencies);
        System.out.println();
        System.out.println("Amount: " + amount);
    }
}
