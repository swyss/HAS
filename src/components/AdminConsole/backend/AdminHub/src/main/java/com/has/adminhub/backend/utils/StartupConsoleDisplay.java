package com.has.adminhub.backend.utils;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupConsoleDisplay implements CommandLineRunner {

    @Override
    public void run(String... args) {
        System.out.println("\033[1;33m" + AsciiArt.getBanner() + "\033[0m");
        System.out.println("\033[1;32mApplication Started Successfully!\033[0m");
        System.out.println("Access the APIs at: http://localhost:8080/api/");
    }
}
