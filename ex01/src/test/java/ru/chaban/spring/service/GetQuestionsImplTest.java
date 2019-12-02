package ru.chaban.spring.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Проверим GetQuestionsImplTest")
class GetQuestionsImplTest {

    @Test
    @DisplayName("прочитали из файла")
    void getQuestions() {
        GetQuestions getQuestions = new GetQuestionsImpl();
        assertEquals(5, getQuestions.getQuestions().length);

        assertEquals("это 1 вопрос", getQuestions.getQuestions()[0].getQuestion());
        assertEquals("ответ 1.1", getQuestions.getQuestions()[0].getAnswers()[0]);
        assertEquals(true, getQuestions.getQuestions()[0].getCorrectAnswers()[0]);
        assertEquals("ответ 1.2", getQuestions.getQuestions()[0].getAnswers()[1]);
        assertEquals(false, getQuestions.getQuestions()[0].getCorrectAnswers()[1]);
        assertEquals("ответ 1.3", getQuestions.getQuestions()[0].getAnswers()[2]);
        assertEquals(false, getQuestions.getQuestions()[0].getCorrectAnswers()[2]);
        assertEquals("ответ 1.4", getQuestions.getQuestions()[0].getAnswers()[3]);
        assertEquals(false, getQuestions.getQuestions()[0].getCorrectAnswers()[3]);
        assertEquals("ответ 1.5", getQuestions.getQuestions()[0].getAnswers()[4]);
        assertEquals(false, getQuestions.getQuestions()[0].getCorrectAnswers()[4]);

        assertEquals("это 2 вопрос", getQuestions.getQuestions()[1].getQuestion());
        assertEquals("ответ 2.1", getQuestions.getQuestions()[1].getAnswers()[0]);
        assertEquals(false, getQuestions.getQuestions()[1].getCorrectAnswers()[0]);
        assertEquals("ответ 2.2", getQuestions.getQuestions()[1].getAnswers()[1]);
        assertEquals(false, getQuestions.getQuestions()[1].getCorrectAnswers()[1]);
        assertEquals("ответ 2.3", getQuestions.getQuestions()[1].getAnswers()[2]);
        assertEquals(true, getQuestions.getQuestions()[1].getCorrectAnswers()[2]);
        assertEquals("ответ 2.4", getQuestions.getQuestions()[1].getAnswers()[3]);
        assertEquals(false, getQuestions.getQuestions()[1].getCorrectAnswers()[3]);

        assertEquals("это 3 вопрос", getQuestions.getQuestions()[2].getQuestion());
        assertEquals("ответ 3.1", getQuestions.getQuestions()[2].getAnswers()[0]);
        assertEquals(false, getQuestions.getQuestions()[2].getCorrectAnswers()[0]);
        assertEquals("ответ 3.2", getQuestions.getQuestions()[2].getAnswers()[1]);
        assertEquals(false, getQuestions.getQuestions()[2].getCorrectAnswers()[1]);
        assertEquals("ответ 3.3", getQuestions.getQuestions()[2].getAnswers()[2]);
        assertEquals(false, getQuestions.getQuestions()[2].getCorrectAnswers()[2]);
        assertEquals("ответ 3.4", getQuestions.getQuestions()[2].getAnswers()[3]);
        assertEquals(false, getQuestions.getQuestions()[2].getCorrectAnswers()[3]);
        assertEquals("ответ 3.5", getQuestions.getQuestions()[2].getAnswers()[4]);
        assertEquals(false, getQuestions.getQuestions()[0].getCorrectAnswers()[4]);

        assertEquals("это 4 вопрос", getQuestions.getQuestions()[3].getQuestion());
        assertEquals("ответ 4.1", getQuestions.getQuestions()[3].getAnswers()[0]);
        assertEquals(false, getQuestions.getQuestions()[3].getCorrectAnswers()[0]);
        assertEquals("ответ 4.2", getQuestions.getQuestions()[3].getAnswers()[1]);
        assertEquals(false, getQuestions.getQuestions()[0].getCorrectAnswers()[1]);

        assertEquals("это 5 вопрос", getQuestions.getQuestions()[4].getQuestion());
        assertEquals("ответ 5.1", getQuestions.getQuestions()[4].getAnswers()[0]);
        assertEquals(true, getQuestions.getQuestions()[4].getCorrectAnswers()[0]);
        assertEquals("ответ 5.2", getQuestions.getQuestions()[4].getAnswers()[1]);
        assertEquals(false, getQuestions.getQuestions()[4].getCorrectAnswers()[1]);
        assertEquals("ответ 5.3", getQuestions.getQuestions()[4].getAnswers()[2]);
        assertEquals(false, getQuestions.getQuestions()[4].getCorrectAnswers()[2]);
    }
}