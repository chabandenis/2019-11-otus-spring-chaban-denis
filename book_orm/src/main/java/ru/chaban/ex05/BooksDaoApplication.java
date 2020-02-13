package ru.chaban.ex05;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.chaban.ex05.domain.Author;

import java.sql.SQLException;

@SpringBootApplication
public class BooksDaoApplication {

    public static void main(String[] args) throws SQLException {
        ApplicationContext context = SpringApplication.run(BooksDaoApplication.class, args);
        Author author = new Author("qqqq");
        Console.main(args);
    }
}
