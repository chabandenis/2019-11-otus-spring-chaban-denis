package ru.chaban.ex3.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.chaban.ex3.service.GetQuestions;
import ru.chaban.ex3.service.GetQuestionsImpl;

@Configuration
public class QuestionsConfig {
    private String testFileName;

    public QuestionsConfig(@Value("${testFileName}") String testFileName) {
        this.testFileName = testFileName;
    }

    @Bean
    public GetQuestions getQuestions() {
        return new GetQuestionsImpl(testFileName);
    }
}