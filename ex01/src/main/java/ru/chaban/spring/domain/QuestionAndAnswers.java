package ru.chaban.spring.domain;

import java.util.List;

public class QuestionAndAnswers {
    private String question;
    private List<String> answers;
    private List<Boolean> correctAnswers;

    public QuestionAndAnswers(String question, List<String> answers, List<Boolean> correctAnswers) {
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
