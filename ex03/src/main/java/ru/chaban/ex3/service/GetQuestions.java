package ru.chaban.ex3.service;

import ru.chaban.ex3.Eexceptions.NoFileWithQuestions;
import ru.chaban.ex3.domain.QuestionAndAnswers;

import java.util.List;

public interface GetQuestions {
    List<QuestionAndAnswers> getQuestions();
}
