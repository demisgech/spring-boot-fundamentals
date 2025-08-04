package com.marakicode.store.exercise;

public interface UserRepository {
    void save(User user);

    User findByEmail(String email);
}
