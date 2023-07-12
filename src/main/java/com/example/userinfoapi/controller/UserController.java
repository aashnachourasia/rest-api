package com.example.userinfoapi.controller;

import com.example.userinfoapi.model.User;
import com.example.userinfoapi.response.ResponseHandler;
import com.example.userinfoapi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//class responsible to expose all rest apis
@RestController
@RequestMapping("/user")
public class UserController
{
    //controller layer interating with service layer
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //read specific user detail
    @GetMapping("{userId}")
    public ResponseEntity<Object> getUserDetails(@PathVariable("userId") String userId)
    {
        return ResponseHandler.responseBuilder(
        "Requested message Details are given here",
                HttpStatus.OK, userService.getUser(userId));

                //new User("c1","fn","ln","abc@gmail.com");
    }

    //read all user details in db
    @GetMapping()
    public List<User> getAllUserDetails()
    {
        return userService.getAllUsers();
        //new User("c1","fn","ln","abc@gmail.com");
    }
    @PostMapping
    public String createUserDetails(@RequestBody User user)
    {
        userService.createUser(user);
        return "User created Successfully";
    }
//put in http used for updation
    @PutMapping
    public String updateUserDetails(@RequestBody User user)
    {
        userService.updateUser(user);
        return "User Updated Successfully";
    }

    @DeleteMapping("{userId}")
    public String deleteUserDetails(@PathVariable("userId") String userId)
    {
        userService.deleteUser(userId);
        return "User Deleted Successfully";
    }
}
