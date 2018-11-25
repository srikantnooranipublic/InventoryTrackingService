package com.example.springboot.demo.book;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.springboot.demo.user.UserResource;



@RestController
public class BookController
{
    @Autowired
    private UserResource userResource;
    
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        

        return Arrays.asList(new Book(1l, "srping", "srikant"));
    }

}
