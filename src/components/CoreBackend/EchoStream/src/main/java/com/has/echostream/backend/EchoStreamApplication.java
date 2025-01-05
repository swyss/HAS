package com.has.core_backend.echostream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EchoStreamApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EchoStreamApplication.class, args);
    }


    @Override
    public void run(String... args) {
        System.out.println("***");
        System.out.println("======================================");
        System.out.println("Application running at: http://localhost:55100/EchoStreamBoard");
        System.out.println("======================================");
        System.out.println("***");
    }
}
