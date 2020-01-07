package ru.chaban.ex3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Проверим QuestionAndAnswersTest")
class QuestionAndAnswersTest {

    @Test
    @DisplayName("создали/прочитали")
    void testQuestionAndAnswersTest() {
        Question questionAndAnswers = new Question(
                "вопрос номер 1",
                Arrays.asList(new String[]{"ответ 1", "ответ 2", "ответ 3", "ответ 4", "ответ 5"}),
                Arrays.asList(new Boolean[]{true, false, true, false, true}));

        assertEquals("вопрос номер 1", questionAndAnswers.getQuestion());

        assertEquals("ответ 1", questionAndAnswers.getAnswers().get(0));
        assertEquals("ответ 2", questionAndAnswers.getAnswers().get(1));
        assertEquals("ответ 3", questionAndAnswers.getAnswers().get(2));
        assertEquals("ответ 4", questionAndAnswers.getAnswers().get(3));
        assertEquals("ответ 5", questionAndAnswers.getAnswers().get(4));

        assertEquals(true, questionAndAnswers.getCorrectAnswers().get(0));
        assertEquals(false, questionAndAnswers.getCorrectAnswers().get(1));
        assertEquals(true, questionAndAnswers.getCorrectAnswers().get(2));
        assertEquals(false, questionAndAnswers.getCorrectAnswers().get(3));
        assertEquals(true, questionAndAnswers.getCorrectAnswers().get(4));
    }

}