package com.library.librarymanagment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryManagmentApplication {

    public static void main(String[] args) {

        SpringApplication.run(LibraryManagmentApplication.class, args);
        System.out.println("application started");
    }

}
