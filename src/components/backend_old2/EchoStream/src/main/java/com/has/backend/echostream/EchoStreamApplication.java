package com.has.backend.echostream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableWebMvc
public class EchoStreamApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EchoStreamApplication.class, args);
    }


    @Override
    public void run(String... args) {
        System.out.println("======================================");
        System.out.println("Application running at: http://localhost:8080/EchoStreamBoard");
        System.out.println("======================================");
    }
}
