package com.marakicode.store;

import java.math.BigDecimal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.marakicode.store.entities.Address;
import com.marakicode.store.entities.Product;
import com.marakicode.store.entities.User;
import com.marakicode.store.repositories.AddressRepository;
import com.marakicode.store.repositories.ProductRepository;
import com.marakicode.store.repositories.UserRepository;
import com.marakicode.store.services.UserService;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StoreApplication.class, args);

		var userRepository = context.getBean(UserRepository.class);

		var user = User.builder()
				.name("User1")
				.email("user1@domain.com")
				.password("password1234")
				.build();

		// userRepository.save(user);
		// var user = userRepository.findById(1L).orElseThrow();
		// System.out.println(user.getEmail());

		// userRepository.findAll()
		// .forEach(user -> System.out.println(user.getEmail()));

		// userRepository.deleteById(1L);

		// var address = Address.builder()
		// .city("Addis Ababa")
		// .street("Main Street")
		// .state("ETH")
		// .zip("ABC123")
		// .build();

		// address.setUser(user);
		// var addressRepository = context.getBean(AddressRepository.class);
		// addressRepository.save(address);

		// var product = Product.builder()
		// .name("Product1")
		// .description("Description")
		// .price(BigDecimal.valueOf(10))
		// .build();

		// var productRepository = context.getBean(ProductRepository.class);
		// productRepository.save(product);

		var service = context.getBean(UserService.class);
		service.manageProducts();

	}

}
