/*
    Результаты теста
 */
package ru.chaban.ex3.domain;

import org.springframework.context.MessageSource;

import java.util.Locale;

public class TestResult {
    // персона
    final private Person person;

    // правильные ответы
    private int correctAnswers = 0;

    // ответы с ошибками
    private int incorrectAnswers = 0;

    // один конструктор с обязательным указанием персоны
    public TestResult(Person person) {
        this.person = person;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public int getIncorrectAnswers() {
        return incorrectAnswers;
    }

    // принять ответ
    public void getAnswer(Boolean isCorrect, MessageSource messageSource, Locale locale) {
        if (isCorrect) {
            correctAnswers++;
            System.out.println(messageSource.getMessage("answer.right", null, locale));
        } else {
            incorrectAnswers--;
            System.out.println(messageSource.getMessage("answer.wrong", null, locale));
        }
    }

    // общее количество вопросов
    public int totalQuestions() {
        return correctAnswers + incorrectAnswers;
    }
}
