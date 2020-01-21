package ru.chaban.ex3.service;

import ru.chaban.ex3.Exceptions.NoFileWithQuestions;
import ru.chaban.ex3.domain.Question;

import java.util.List;

public interface Commands {
    List<Question> getQuestions() throws NoFileWithQuestions;
}
