package com.example.expenseapi.controller;

import com.example.expenseapi.model.User;
import com.example.expenseapi.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//class responsible to expose all rest apis
@RestController
@RequestMapping("/user")
public class ExpenseApiController
{
    //controller layer interating with service layer
    UserService userService;

    public ExpenseApiController(UserService userService) {
        this.userService = userService;
    }

    //read specific user detail
    @GetMapping("{userId}")
    public User getUserDetails(@PathVariable("userId") String userId)
    {
       return userService.getUser(userId);
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
