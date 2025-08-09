package com.marakicode.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.marakicode.store.exercise.User;
import com.marakicode.store.exercise.UserService;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
		// ConfigurableApplicationContext context =
		// SpringApplication.run(StoreApplication.class,
		// args);
		// var orderService = context.getBean(OrderService.class);
		// // var orderService2 = context.getBean(OrderService.class);
		// orderService.placeOrder();

		// var notificationManager = context.getBean(NotificationManager.class);
		// notificationManager.sendNotification("Your message goes here ...");

		// var userService = context.getBean(UserService.class);
		// userService.registerUser(new User(1L, "Demis", "demis@domain.com", "1234"));
		// userService.registerUser(new User(1L, "Demis", "demis@domain.com", "1234"));
		// context.close();
	}

}
