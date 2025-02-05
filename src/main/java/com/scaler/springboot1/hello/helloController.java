package com.scaler.springboot1.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
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
}

@Controller
@RequestMapping("/web")
public class WebController {
    @GetMapping("/home")
    public String home() {
        return "homepage";  // Returns a view (e.g., homepage.html)
    }
}
