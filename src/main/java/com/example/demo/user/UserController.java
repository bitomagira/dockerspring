package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService myUserService;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return myUserService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
    public User createUser(@RequestBody User user) {

        return myUserService.postUser(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public User updateUser(@RequestBody User newUser) {
        return myUserService.putUser(newUser);
    }

    @RequestMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return myUserService.getOneUser(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable int id) {
        myUserService.deleteUser(id);
    }

}
