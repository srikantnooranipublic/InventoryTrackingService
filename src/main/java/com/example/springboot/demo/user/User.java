package com.example.springboot.demo.user;

public class User
{
    private Integer id;
    private String name;
    
    public User ( Integer id, String name ) {
        super();
        
        this.id = id;
        this.name = name;
    }
    
    public Integer getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setId (Integer id) {
        this.id = id;
    }
}
