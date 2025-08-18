package com.marakicode.store.services;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.marakicode.store.entities.Address;
import com.marakicode.store.entities.Category;
import com.marakicode.store.entities.Product;
import com.marakicode.store.entities.User;
import com.marakicode.store.ioc.AppConfig;
import com.marakicode.store.repositories.AddressRepository;
import com.marakicode.store.repositories.CategoryRepository;
import com.marakicode.store.repositories.ProductRepository;
import com.marakicode.store.repositories.ProfileRepository;
import com.marakicode.store.repositories.UserRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service("user-service")
public class UserService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final AddressRepository addressRepository;
    private final EntityManager entityManager;

    @Transactional
    public void showEntityStates() {
        var user = User.builder()
                .name("Yohannis")
                .email("yohannis@gmail.com")
                .password("password")
                .build();

        if (entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient / Detached");
        userRepository.save(user);
        System.out.println("After User Saved");

        if (entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient / Detached");
    }

    // @Transactional
    public void showRelatedEntities() {
        // var user = userRepository.findById(4L).orElseThrow();
        // System.out.println(user.getEmail());

        // var profile = profileRepository.findById(4L).orElseThrow();
        // Eager Loading
        // System.out.println(profile.getBio());

        // Lazy loading, so to solve these issue we have to make it transactional
        // System.out.println(profile.getUser().getEmail());

    }

    public void fetchAddress() {
        var address = addressRepository.findById(1L).orElseThrow();
        System.out.println(address);
    }

    public void fetchProduct() {
        var product = productRepository.findById(1L).orElseThrow();
        System.out.println(product.getName());
    }

    public void persistRelated() {
        var user = User.builder()
                .name("User1")
                .email("user1@gmail.com")
                .password("password")
                .build();

        var address = Address.builder()
                .street("street")
                .city("city")
                .state("state")
                .zip("zip")
                .build();

        user.addAddress(address);
        userRepository.save(user);

    }

    @Transactional
    public void deleteRelated() {
        // userRepository.deleteById(6L);
        var user = userRepository.findById(3L).orElseThrow();
        var address = user.getAddresses().getFirst();
        user.removeAddress(address);
        userRepository.save(user);
    }

    @Transactional
    public void manageProducts() {
        // var product = Product.builder()
        // .name("product1")
        // .price(BigDecimal.valueOf(10.1))
        // .description("description")
        // .build();

        // var category = Category.builder()
        // .name("New Category")
        // .build();

        // product.setCategory(category);
        // category.getProducts().add(product);
        // productRepository.save(product);

        // Add a new product to an existing category
        // var product2 = Product.builder()
        // .name("product2")
        // .price(BigDecimal.valueOf(4.55))
        // .description("new description")
        // .build();

        // var category2 = categoryRepository.findById(2L).orElseThrow();

        // product2.setCategory(category2);
        // category2.getProducts().add(product2);
        // productRepository.save(product2);

        // Add products to User's Wishlist
        // var user = userRepository.findById(3L).orElseThrow();
        // var products = productRepository.findAll();
        // products.forEach(product -> {
        // user.addWishList(product);
        // });
        // userRepository.save(user);

        // Deleting products
        productRepository.deleteById(2L);
    }
}
