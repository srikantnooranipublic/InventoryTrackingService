package com.example.springboot.demo.mobile;

public class Mobile
{
    long id;
    String name;
    String author;
    
    public Mobile ( long id, String name, String author ) {
        super ();
        
        this.name = name;
        this.author = author;
        this.id = id;
    }
    
    public long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getAuthor() {
        return author;
    }
}
