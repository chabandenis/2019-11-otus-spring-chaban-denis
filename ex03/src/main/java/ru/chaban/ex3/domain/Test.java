package ru.chaban.ex3.domain;

import org.springframework.context.MessageSource;

import java.util.List;
import java.util.Locale;

/*
    Результаты теста
 */
public class Test {
    // персона
    final private Person person;

    // вопросы
    final private Questions questions;

    // правильные ответы
    private int correctAnswers = 0;

    // ответы с ошибками
    private int incorrectAnswers = 0;

    public List<Question> getQuestions() {
        return questions.getQuestions();
    }

    // один конструктор с обязательным указанием персоны
    public Test(Person person, Questions questions) {
        this.person = person;
        this.questions = questions;
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
