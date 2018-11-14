package com.example.springboot.demo.printer;

public class Printer
{
    long id;
    String name;
    String author;
    
    public Printer ( long id, String name, String author ) {
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
