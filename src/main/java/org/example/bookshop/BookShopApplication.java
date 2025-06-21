package org.example.bookshop;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class BookShopApplication {
    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(BookShopApplication.class, args);
    }
}
