package ru.chaban.ex3.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.chaban.ex3.Eexceptions.NoFileWithQuestions;
import ru.chaban.ex3.domain.QuestionAndAnswers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Проверим GetQuestionsImplTest")
class GetQuestionsImplTest {

    @Test
    @DisplayName("прочитали из файла")
    void getQuestions() throws NoFileWithQuestions {

        GetQuestions getQuestions = new GetQuestionsImpl("questions.csv");
        List<QuestionAndAnswers> questionAndAnswers = getQuestions.getQuestions();
                

        assertEquals(5, questionAndAnswers.size());

        assertEquals("это 1 вопрос", questionAndAnswers.get(0).getQuestion());
        assertEquals("ответ 1.1", questionAndAnswers.get(0).getAnswers().get(0));
        assertEquals(true, questionAndAnswers.get(0).getCorrectAnswers().get(0));
        assertEquals("ответ 1.2", questionAndAnswers.get(0).getAnswers().get(1));
        assertEquals(false, questionAndAnswers.get(0).getCorrectAnswers().get(1));
        assertEquals("ответ 1.3", questionAndAnswers.get(0).getAnswers().get(2));
        assertEquals(false, questionAndAnswers.get(0).getCorrectAnswers().get(2));
        assertEquals("ответ 1.4", questionAndAnswers.get(0).getAnswers().get(3));
        assertEquals(false, questionAndAnswers.get(0).getCorrectAnswers().get(3));
        assertEquals("ответ 1.5", questionAndAnswers.get(0).getAnswers().get(4));
        assertEquals(false, questionAndAnswers.get(0).getCorrectAnswers().get(4));

        assertEquals("это 2 вопрос", questionAndAnswers.get(1).getQuestion());
        assertEquals("ответ 2.1", questionAndAnswers.get(1).getAnswers().get(0));
        assertEquals(false, questionAndAnswers.get(1).getCorrectAnswers().get(0));
        assertEquals("ответ 2.2", questionAndAnswers.get(1).getAnswers().get(1));
        assertEquals(false, questionAndAnswers.get(1).getCorrectAnswers().get(1));
        assertEquals("ответ 2.3", questionAndAnswers.get(1).getAnswers().get(2));
        assertEquals(true, questionAndAnswers.get(1).getCorrectAnswers().get(2));
        assertEquals("ответ 2.4", questionAndAnswers.get(1).getAnswers().get(3));
        assertEquals(false, questionAndAnswers.get(1).getCorrectAnswers().get(3));

        assertEquals("это 3 вопрос", questionAndAnswers.get(2).getQuestion());
        assertEquals("ответ 3.1", questionAndAnswers.get(2).getAnswers().get(0));
        assertEquals(false, questionAndAnswers.get(2).getCorrectAnswers().get(0));
        assertEquals("ответ 3.2", questionAndAnswers.get(2).getAnswers().get(1));
        assertEquals(false, questionAndAnswers.get(2).getCorrectAnswers().get(1));
        assertEquals("ответ 3.3", questionAndAnswers.get(2).getAnswers().get(2));
        assertEquals(false, questionAndAnswers.get(2).getCorrectAnswers().get(2));
        assertEquals("ответ 3.4", questionAndAnswers.get(2).getAnswers().get(3));
        assertEquals(false, questionAndAnswers.get(2).getCorrectAnswers().get(3));
        assertEquals("ответ 3.5", questionAndAnswers.get(2).getAnswers().get(4));
        assertEquals(false, questionAndAnswers.get(0).getCorrectAnswers().get(4));

        assertEquals("это 4 вопрос", questionAndAnswers.get(3).getQuestion());
        assertEquals("ответ 4.1", questionAndAnswers.get(3).getAnswers().get(0));
        assertEquals(false, questionAndAnswers.get(3).getCorrectAnswers().get(0));
        assertEquals("ответ 4.2", questionAndAnswers.get(3).getAnswers().get(1));
        assertEquals(false, questionAndAnswers.get(0).getCorrectAnswers().get(1));

        assertEquals("это 5 вопрос", questionAndAnswers.get(4).getQuestion());
        assertEquals("ответ 5.1", questionAndAnswers.get(4).getAnswers().get(0));
        assertEquals(true, questionAndAnswers.get(4).getCorrectAnswers().get(0));
        assertEquals("ответ 5.2", questionAndAnswers.get(4).getAnswers().get(1));
        assertEquals(false, questionAndAnswers.get(4).getCorrectAnswers().get(1));
        assertEquals("ответ 5.3", questionAndAnswers.get(4).getAnswers().get(2));
        assertEquals(false, questionAndAnswers.get(4).getCorrectAnswers().get(2));
    }
}