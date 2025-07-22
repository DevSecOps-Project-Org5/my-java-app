package com.example.myjavaapp; 
 
import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.RestController; 
 
@SpringBootApplication 
@RestController 
public class MyJavaAppApplication { 
 
    public static void main(String[] args) { 
        SpringApplication.run(MyJavaAppApplication.class, args); 
    } 
 
    @GetMapping("/") 
    public String home() { 
        return "Hello from Spring Boot MyJavaApp! Version 1.0"; 
    } 
 
    @GetMapping("/health") 
    public String health() { 
        return "UP"; // Simple health check 
    } 
} 