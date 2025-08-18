package com.marakicode.store.repositories;

import org.springframework.data.repository.CrudRepository;

import com.marakicode.store.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
