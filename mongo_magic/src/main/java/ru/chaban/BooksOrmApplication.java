package ru.chaban;

import com.github.cloudyrock.spring.v5.EnableMongock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import ru.chaban.repository.AuthorRepository;


import java.io.Console;
import java.sql.SQLException;

@EnableMongock
@EnableMongoRepositories
@SpringBootApplication
public class BooksOrmApplication {

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private AuthorRepository repository;

    public static void main(String[] args) throws InterruptedException {
        //ApplicationContext context = SpringApplication.run(BooksOrmApplication.class, args);
        ApplicationContext context = SpringApplication.run(BooksOrmApplication.class);
        //Console.main(args);
    }
}
