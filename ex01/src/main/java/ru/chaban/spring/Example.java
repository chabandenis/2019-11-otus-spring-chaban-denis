package ru.chaban.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.chaban.spring.service.GetQuestions;
import ru.chaban.spring.service.GetQuestionsImpl;
import ru.chaban.spring.service.TestStudent;
import ru.chaban.spring.service.TestStudentImpl;

public class Example {
    public static void main(String[] args) {


        GetQuestions getQuestions = new GetQuestionsImpl();
        TestStudent testStudent0 = new TestStudentImpl(getQuestions);

//        testStudent0.testStudent();



        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

        TestStudent testStudent = context.getBean(TestStudent.class);
        testStudent.testStudent();

    }
}
