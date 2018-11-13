package com.example.springboot.demo.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class userDaoServices
{
    private static List<User> users = new ArrayList<>();
    private static int usersCount=2;
 
    private static int counter = 1;
    
    static {
        users.add(new User(1, "Raj"));
        users.add(new User(2, "Srikant"));
    }
    
    public List<User> findAll () {
        

        try
        {
            
            if ( counter++ % 5 == 0 || counter % 6 == 0) {
                Thread.sleep(10000);
                System.out.println("Slowing the USer DB trx ");
            }
            
        } catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return users;
    }
    
    public User save (User user) {
        if ( user.getId() == null) {
            user.setId(++usersCount);
            
        }
        
        return user;
    }
}
