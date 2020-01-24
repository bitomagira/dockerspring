package com.example.demo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService myUserService;

    @RequestMapping()
    public List<UserModel> getAllUsers(){
        return myUserService.getAllUsers();
    }
    @RequestMapping(value = "",method = RequestMethod.POST)
    public UserModel createUser(@RequestBody UserModel user){
        return myUserService.postUser(user);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public UserModel updateUser(@RequestBody UserModel newUser){
        return myUserService.putUser(newUser);
    }
    @RequestMapping("/{id}")
    public Optional<UserModel> getUser(@PathVariable int id){
        return myUserService.getOneUser(id);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable int id){
         myUserService.deleteUser(id);
    }

}
