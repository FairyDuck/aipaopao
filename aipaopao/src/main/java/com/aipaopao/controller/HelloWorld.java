package com.aipaopao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld
{
    @GetMapping("/hello")
    public String hello(Integer id)
    {
        return "hellowrold " + id;
    }
}
