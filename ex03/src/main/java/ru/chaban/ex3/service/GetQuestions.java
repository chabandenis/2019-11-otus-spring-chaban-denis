package ru.chaban.spring.service;

import ru.chaban.spring.Eexceptions.NoFileWithQuestions;
import ru.chaban.spring.domain.QuestionAndAnswers;

import java.util.List;

public interface GetQuestions {
    List<QuestionAndAnswers> getQuestions() throws NoFileWithQuestions;
}
