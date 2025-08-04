package com.marakicode.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		// SpringApplication.run(StoreApplication.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(StoreApplication.class,
				args);
		var orderService = context.getBean(OrderService.class);
		// var orderService2 = context.getBean(OrderService.class);
		orderService.placeOrder();

		var notificationManager = context.getBean(NotificationManager.class);
		notificationManager.sendNotification("Your message goes here ...");
		context.close();
	}

}
