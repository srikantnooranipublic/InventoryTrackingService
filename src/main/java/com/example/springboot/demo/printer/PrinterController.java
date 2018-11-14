package com.example.springboot.demo.printer;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.springboot.demo.user.UserResource;



@RestController
public class PrinterController
{
    @Autowired
    private UserResource userResource;
    
    @GetMapping("/printers")
    public List<Printer> getAllBooks() throws IllegalAccessException {
        

        throw new IllegalAccessException("Do not have access to Printers");
    }

}
