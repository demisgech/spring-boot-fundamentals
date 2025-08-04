package com.marakicode.store.exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    final private UserRepository userRepository;
    final private NotificationService notificationService;

    @Autowired
    public UserService(UserRepository userRepository, NotificationService notificationService) {
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }

    public void registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("User with email " + user.getEmail() + " already exist!");
        }
        userRepository.save(user);
        notificationService.send("You registered successfully!!", user.getEmail());
    }
}
