package ru.chaban.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.chaban.spring.service.TestStudent;
import ru.chaban.spring.service.TestStudentImpl;

@ComponentScan
@Configuration
public class Example {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Example.class);
        TestStudent testStudent = context.getBean(TestStudentImpl.class);
        testStudent.testStudent();
    }
}
