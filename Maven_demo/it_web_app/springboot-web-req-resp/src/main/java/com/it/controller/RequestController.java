package com.it.controller;

import com.it.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
public class RequestController {

//    @RequestMapping("/simpleParam")
//    public String simpleParam(HttpServletRequest request){
//        System.out.println("111");
//
//        String name = request.getParameter("name");
//        String ageStr = request.getParameter("age");
//        int age = Integer.parseInt(ageStr);
//
//        System.out.println(name+": "+ age);
//
//        return "ok";
//    }

//    @RequestMapping("/simpleParam")
//    public String simpleParam(String name,String age){
//        System.out.println(name+": "+ age);
//
//        return "ok";
//    }

    @RequestMapping("/simpleParam")
    public String simpleParam(@RequestParam(name="name", required = false) String username, String age){
        System.out.println(username+": "+ age);

        return "ok";
    }

    @RequestMapping("/simplePojo")
    public String simplePojo(User user){
        System.out.println(user);
        return "ok!!!";
    }

    @RequestMapping("/complexPojo")
    public String complexPojo(User user){
        System.out.println(user);
        return "ok!!!";
    }


    @RequestMapping("/arrayParam")
    public String arrayParam(String[] hobby){
        System.out.println(Arrays.toString(hobby));
        return "ok!!!arrayParam";
    }

    @RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> hobby){
        System.out.println(hobby);
        return "ok!!!listParam";
    }

    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")LocalDateTime updateTime){
        System.out.println(updateTime);
        return "ok";
    }


    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user){
        System.out.println(user);
        return "ok!";
    }

    @RequestMapping("/path/{id}")
    public String pathParam(@PathVariable Integer id){
        System.out.println(id);
        return "ok!";
    }

    @RequestMapping("/path/{id}/{name}")
    public String mulPathParam(@PathVariable Integer id,@PathVariable String name){
        System.out.println(id+": "+ name);
        return "ok!";
    }


}
