/*
    Список всех вопросов с возможными вариантами ответов
 */

package ru.chaban.ex3.domain;

import ru.chaban.ex3.service.GetQuestions;

import java.util.List;

public class Questions {
    private List<Question> questions;

    public Questions(GetQuestions getQuestions) {
        this.questions = getQuestions.getQuestions();
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
