package ru.chaban;

import com.github.cloudyrock.spring.v5.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


import java.sql.SQLException;

@EnableMongock
@EnableMongoRepositories
@SpringBootApplication
public class BooksOrmApplication {

    public static void main(String[] args) throws SQLException {
        ApplicationContext context = SpringApplication.run(BooksOrmApplication.class, args);
        Console.main(args);
    }
}
