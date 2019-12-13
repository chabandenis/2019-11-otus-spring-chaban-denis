package ru.chaban.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.chaban.spring.service.GetQuestions;
import ru.chaban.spring.service.TestStudent;
import ru.chaban.spring.service.TestStudentImpl;

@Configuration
public class TestStudentConfig {
    @Bean
    public TestStudent testStudent(GetQuestions getQuestions) {
        return new TestStudentImpl(getQuestions);
    }
}
