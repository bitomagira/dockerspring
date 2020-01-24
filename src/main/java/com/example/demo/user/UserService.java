package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository myUserRepository;

    public List<UserModel> getAllUsers() {
        return myUserRepository.findAll();
    }

    public UserModel postUser(UserModel user) {
        return myUserRepository.save(user);
    }

    public UserModel putUser(UserModel newUser) {
        return myUserRepository.save(newUser);
    }

    public Optional<UserModel> getOneUser(int id) {
        return myUserRepository.findById(id);
    }

    public void deleteUser(int id) {
        myUserRepository.deleteById(id);
    }
}
