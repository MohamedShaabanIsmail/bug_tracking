package com.Ashmo.BugTracking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.Ashmo.BugTracking.Model.Users;
import com.Ashmo.BugTracking.Service.UsersService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/add")
    public String addUser(@RequestBody Users user) {
        usersService.addUser(user);
        return "User added successfully";        
    }
    
    @GetMapping("/by_id/{id}")
    public Users getMethodName(@PathVariable int id) {
        return usersService.getUserById(id);
    }
    
}
