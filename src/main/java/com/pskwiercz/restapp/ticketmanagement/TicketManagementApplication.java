package com.pskwiercz.restapp.ticketmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@Controller
public class TicketmanagementApplication {
    @ResponseBody
    @RequestMapping("/")
    public String sayHello() {
        return "Hello";
    }

    public static void main(String[] args) {
        SpringApplication.run(TicketmanagementApplication.class, args);
    }
}

