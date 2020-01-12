package ru.chaban.ex3.domain;

import ru.chaban.ex3.service.GetQuestions;

import java.util.List;

/*
    Список всех вопросов с возможными вариантами ответов
 */
public class Questions {
    final private List<Question> questions;

    public Questions(GetQuestions getQuestions) {
        this.questions = getQuestions.getQuestions();
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
