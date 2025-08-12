package com.marakicode.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.marakicode.store.entities.Address;
import com.marakicode.store.entities.Category;
import com.marakicode.store.entities.Product;
import com.marakicode.store.entities.Profile;
import com.marakicode.store.entities.Tag;
import com.marakicode.store.entities.User;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		// SpringApplication.run(StoreApplication.class, args);
		// ConfigurableApplicationContext context =
		// SpringApplication.run(StoreApplication.class,
		// args);

		var category = Category.builder()
				.name("category1")
				.build();

		var product = Product.builder()
				.id(1L)
				.name("Product1")
				.build();

		category.getProducts().add(product);
		product.setCategory(category);
		System.out.println(category);
		// context.close();
	}

}
