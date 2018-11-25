package com.example.springboot.demo.mobile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.springboot.demo.user.UserResource;



@RestController
public class MobileController
{

    @GetMapping("/mobiles")
    public List<Mobile> getAllMobile()  {
        

        
       return  callDatabase();
    }
    
    public List<Mobile> callDatabase()  {
        
        com.example.springboot.demo.WS.ProjectRestWS ws = new com.example.springboot.demo.WS.ProjectRestWS();
        ws.validateWS();
      
        ArrayList<Mobile> list = new ArrayList<>();
        list.add(new Mobile(1, "galaxy","samsung"));

        return list;
    }

}
