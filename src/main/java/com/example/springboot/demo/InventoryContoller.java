package com.example.springboot.demo;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.springboot.demo.book.Book;
import com.example.springboot.demo.user.User;

@Controller 
public class InventoryContoller
{

    @GetMapping("/inventory/users")
    @ResponseBody
    public String getUsers() {

        try {
            URL url;
            url = new URL("http://localhost:8080/users");

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            
            int responseCode = con.getResponseCode();
            
            System.out.println(" response code for book is " + responseCode);
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "User retrieval successful";
    }

    @GetMapping("/inventory/books")
    @ResponseBody
    public String getBooks() {

        URL url ;
        try
        {

            url= new URL("http://localhost:8080/books");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            
            System.out.println(" response code for book is " + responseCode);

        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "Book retrieval successful";
    }
    
    @GetMapping("/inventory/computers")
    @ResponseBody
    public String getComnputers() {

        URL url ;
        try
        {

            url= new URL("http://localhost:8080/books");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            
            System.out.println(" response code for book is " + responseCode);

        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "Computers retrieval successful";
    }
    
    


}
