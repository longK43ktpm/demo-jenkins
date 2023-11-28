package com.example.demojenkins;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private String name = "Spring ";

    public String show() {
        return "hello " + name;
    }

    @GetMapping("/")
    public String index() {
        return show();
    }

}