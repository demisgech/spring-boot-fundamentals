package com.marakicode.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		// SpringApplication.run(StoreApplication.class, args);
		ApplicationContext context = SpringApplication.run(StoreApplication.class,
				args);
		var orderService = context.getBean(OrderService.class);
		orderService.placeOrder();

		var notificationManager = context.getBean(NotificationManager.class);
		notificationManager.sendNotification("Your message goes here ...");
	}

}
