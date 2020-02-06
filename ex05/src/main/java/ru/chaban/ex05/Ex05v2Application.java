package ru.chaban.ex05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.SQLException;

@SpringBootApplication
public class Ex05v2Application {

    public static void main(String[] args) throws SQLException {
        ApplicationContext context = SpringApplication.run(Ex05v2Application.class, args);
        //Console.main(args);
    }
}
