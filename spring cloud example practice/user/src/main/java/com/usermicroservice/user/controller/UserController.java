package com.usermicroservice.user.controller;

import com.usermicroservice.user.dto.ResponseTemplate;
import com.usermicroservice.user.entity.User;
import com.usermicroservice.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplate getUserByDepartmentId(@PathVariable("id") Long userId){
        return userService.getUserByDepartmentId(userId);
    }

}
