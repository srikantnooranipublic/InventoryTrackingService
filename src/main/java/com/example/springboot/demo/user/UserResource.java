package com.example.springboot.demo.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource
{
    
    @Autowired
    private userDaoServices service;
    
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        
        com.example.springboot.demo.WS.ProjectRestWS ws = new com.example.springboot.demo.WS.ProjectRestWS();
        
        ws.validateWS();
        
        return service.findAll();
    }

}
