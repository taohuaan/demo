package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;

@RestController
public class HelloController {
    @RequestMapping("/sayHello")
    public String sayHello(){
        return "hello world";
    }

    LinkedList<String> list = new LinkedList<String>();



}
