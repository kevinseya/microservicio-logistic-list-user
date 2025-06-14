package com.microserviciologistic.listuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class ListUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ListUserApplication.class, args);
    }

    @GetMapping("/")
    public String redirectToGraphiQL() {
        return "redirect:/graphiql?path=/graphql";
    }

}
