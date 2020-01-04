/*
    Список всех вопросов с возможными вариантами ответов
 */

package ru.chaban.ex3.domain;

import ru.chaban.ex3.service.GetQuestions;

import java.util.ArrayList;
import java.util.List;

public class Questions {
    private List<QuestionAndAnswers> questions;

    public Questions(GetQuestions getQuestions) {
        this.questions = getQuestions.getQuestions();
    }

    public List<QuestionAndAnswers> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionAndAnswers> questions) {
        this.questions = questions;
    }
}
