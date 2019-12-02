package ru.chaban.spring.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Проверим QuestionAndAnswersTest")
class QuestionAndAnswersTest {

    @Test
    @DisplayName("создали/прочитали")
    void testQuestionAndAnswersTest() {
        QuestionAndAnswers questionAndAnswers = new QuestionAndAnswers(
                "вопрос номер 1",
                new String[]{"ответ 1", "ответ 2", "ответ 3", "ответ 4", "ответ 5"},
                new Boolean[]{true, false, true, false, true});

        assertEquals("вопрос номер 1", questionAndAnswers.getQuestion());

        assertEquals("ответ 1", questionAndAnswers.getAnswers()[0]);
        assertEquals("ответ 2", questionAndAnswers.getAnswers()[1]);
        assertEquals("ответ 3", questionAndAnswers.getAnswers()[2]);
        assertEquals("ответ 4", questionAndAnswers.getAnswers()[3]);
        assertEquals("ответ 5", questionAndAnswers.getAnswers()[4]);

        assertEquals(true, questionAndAnswers.getCorrectAnswers()[0]);
        assertEquals(false, questionAndAnswers.getCorrectAnswers()[1]);
        assertEquals(true, questionAndAnswers.getCorrectAnswers()[2]);
        assertEquals(false, questionAndAnswers.getCorrectAnswers()[3]);
        assertEquals(true, questionAndAnswers.getCorrectAnswers()[4]);
    }

}