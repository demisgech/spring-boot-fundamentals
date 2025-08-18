package com.marakicode.store.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.marakicode.store.entities.Product;
import java.math.BigDecimal;

public interface ProductRepository extends CrudRepository<Product, Long> {

    // Derived query
    // String

    // SELECT * FROM products WHERE name = ?
    List<Product> findByName(String name);

    // SELECT * FROM products WHERE name LIKE ?
    List<Product> findByNameLike(String name);

    List<Product> findByNameNotLike(String name);

    List<Product> findByNameContaining(String name);

    List<Product> findByNameContains(String name);

    List<Product> findByNameStartingWith(String name);

    List<Product> findByNameStartsWith(String name);

    List<Product> findByNameEndingWith(String name);

    List<Product> findByNameEndsWith(String name);

    List<Product> findByNameContainingIgnoreCase(String name);

    // Price or number

    List<Product> findByPrice(BigDecimal price);

    List<Product> findBYPriceGreaterThan(BigDecimal price);

    List<Product> findBYPriceGreaterThanEqual(BigDecimal price);

    List<Product> findBYPriceLessThan(BigDecimal price);

    List<Product> findBYPriceLessThanEqual(BigDecimal price);

    List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);

    // Working with Nullable

    List<Product> findByDescriptionNull(String description);

    List<Product> findByDescriptionNotNull();

    // Multiple condition with conditional operators

    List<Product> findByDescriptionNullAndNamNull();

    List<Product> findByDescriptionNullOrNameNotNull();

    // Sort(OrderBy)

    List<Product> findByNameOrderByAsc(String name);

    List<Product> findByNameOrderByPriceDesc(String name);

    // Limit(Top/First)
    List<Product> findTop5ByNameOrderByPriceDesc(String name);

    List<Product> findFirst5ByNameLikeOrderByPriceAsc(String name);

    // @Query("SELECT p FROM products AS p WHERE price BETWEEN :min AND :max")
    // List<Product> findProducts(@Param("min") BigDecimal min, @Param("max")
    // BigDecimal max);

    @Query("SELECT p FROM Product AS p WHERE p.price BETWEEN :min AND :max")
    List<Product> findProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max);
}
