/*
    Вопрос(один вопрос) с вариантами ответов
 */

package ru.chaban.ex3.domain;

import java.util.List;

public class Question {
    private String question;
    private List<String> answers;
    private List<Boolean> correctAnswers;

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