package ru.chaban.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.chaban.spring.service.GetQuestions;
import ru.chaban.spring.service.GetQuestionsImpl;

@Configuration
public class QuestionsConfig {
//test
    private String testFileName;

    public QuestionsConfig(@Value("${testFileName}") String testFileName) {
        this.testFileName = testFileName;
    }

    @Bean
    public GetQuestions getQuestions() {
        return new GetQuestionsImpl(testFileName);
    }
}
