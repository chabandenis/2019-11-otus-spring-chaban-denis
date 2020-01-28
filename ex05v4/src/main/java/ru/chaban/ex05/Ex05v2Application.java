package ru.chaban.ex05;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.chaban.ex05.dao.MyBooksDao;

import java.sql.SQLException;

@SpringBootApplication
public class Ex05v2Application {

	public static void main(String[] args) throws SQLException {
		ApplicationContext context = SpringApplication.run(Ex05v2Application.class, args);

		Console.main(args);

		MyBooksDao books = context.getBean(MyBooksDao.class);

		System.out.println("количество книг " + books.count());

	//	books.insert(new MyBooks((long)1, (long)1));

		System.out.println("количество книг " + books.count());


	}

}
