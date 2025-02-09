package com.scaler.springboot1.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
//@Controller
@RequestMapping("/hello")
public class helloController {

    @GetMapping("/world")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/you")
    public String helloYou(@RequestParam("name") String name) {
        return "Hello "+name+"!";
    }
    // same method name but different parameters
    @PostMapping("/world")
    public String helloWorld(@RequestBody UserRequest userRequest) {
        return "Hello "+userRequest.getName()+"!";

    }
}

class UserRequest{
    private String name;
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
}
