package ru.chaban.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.chaban.spring.service.GetQuestions;
import ru.chaban.spring.service.GetQuestionsImpl;

@Configuration
public class QuestionsConfig {
    @Bean
    public GetQuestions getQuestions() {
        return new GetQuestionsImpl();
    }
}
