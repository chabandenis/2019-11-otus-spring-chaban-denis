package ru.chaban.ex05;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.SQLException;

@SpringBootApplication
public class BooksOrmApplication {

    public static void main(String[] args) throws SQLException {
        ApplicationContext context = SpringApplication.run(BooksOrmApplication.class, args);
        Console.main(args);
    }
}
