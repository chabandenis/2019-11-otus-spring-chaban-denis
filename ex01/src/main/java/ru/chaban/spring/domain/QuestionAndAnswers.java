package ru.chaban.spring.domain;

public class QuestionAndAnswers {
    private String question;
    private String[] answers;
    private Boolean[] correctAnswers;

    public QuestionAndAnswers(String question, String[] answers, Boolean[] correctAnswers) {
        this.question = question;
        this.answers = answers;
        this.correctAnswers = correctAnswers;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public Boolean[] getCorrectAnswers() {
        return correctAnswers;
    }

}
