package ru.chaban.ex3.domain;

import ru.chaban.ex3.Exceptions.NoFileWithQuestions;
import ru.chaban.ex3.service.Commands;

import java.util.List;

/*
    Список всех вопросов с возможными вариантами ответов
 */
public class Questions {
    final private List<Question> questions;

    public Questions(Commands commands) throws NoFileWithQuestions {
        this.questions = commands.getQuestions();
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
