package ru.chaban.ex3.domain;

import java.util.List;

/*
    Вопрос(один вопрос) с вариантами ответов
 */
public class Question {

    // текст вопроса
    final private String question;

    // предполагаемые ответы
    final private List<String> answers;

    // правильный ответ
    final private List<Boolean> correctAnswers;

    public Question(String question, List<String> answers, List<Boolean> correctAnswers) {
        this.question = question;
        this.answers = answers;
        this.correctAnswers = correctAnswers;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public List<Boolean> getCorrectAnswers() {
        return correctAnswers;
    }
}
