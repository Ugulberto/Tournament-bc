package com.equipo07.torneo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.equipo07.torneo.DTO.UserDTO;
import com.equipo07.torneo.service.UserService;

@RestController
@RequestMapping("/users") 
public class UserController {
    
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping("/user/{id}")
    public UserDTO getUser(@PathVariable Integer id) {
        UserDTO user = userService.getUserById(id);
        return user;
    }

}
