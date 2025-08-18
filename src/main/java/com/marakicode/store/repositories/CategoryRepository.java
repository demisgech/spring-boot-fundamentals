package com.marakicode.store.repositories;

import org.springframework.data.repository.CrudRepository;

import com.marakicode.store.entities.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
