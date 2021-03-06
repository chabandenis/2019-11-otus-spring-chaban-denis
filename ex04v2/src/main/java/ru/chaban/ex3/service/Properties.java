package ru.chaban.ex3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

/*
  Свойства прилолжения в этом классе, иначе приходится передвать их параметрами
 */
@Component
@ConfigurationProperties("db")
public class Properties {

    // сообщения
   final private MessageSource messageSource;

    // локализация
    private Locale locale;

    // минимальное количество вопросов для прохождения теста
    private int minimumPositiveQuestionsForPassExam;

    // название файла
    private String testFileName;

    public Properties(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getTestFileName() {
        return testFileName;
    }

    public void setTestFileName(String testFileName) {
        this.testFileName = testFileName;
    }

    public int getMinimumPositiveQuestionsForPassExam() {
        return minimumPositiveQuestionsForPassExam;
    }

    public void setMinimumPositiveQuestionsForPassExam(int minimumPositiveQuestionsForPassExam) {
        this.minimumPositiveQuestionsForPassExam = minimumPositiveQuestionsForPassExam;
    }

    public MessageSource getMessageSource() {
        return messageSource;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}
