package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository myUserRepository;

    public List<User> getAllUsers() {
        return myUserRepository.findAll();
    }

    public User postUser(User user) {
        return myUserRepository.save(user);
    }

    public User putUser(User newUser) {
        return myUserRepository.save(newUser);
    }

    public User getOneUser(int id) {
        return myUserRepository.findById(id).get();
    }

    public void deleteUser(int id) {
        myUserRepository.deleteById(id);
    }
}
