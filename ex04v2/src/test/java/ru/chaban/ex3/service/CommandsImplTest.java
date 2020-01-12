package ru.chaban.ex3.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import ru.chaban.ex3.Exceptions.NoFileWithQuestions;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Проверим GetQuestionsImplTest")
@SpringBootTest(properties = {
        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
class CommandsImplTest {

    @Autowired
    // переменная нужна для считывания файла
            Properties properties;

    @Test
    @DisplayName("прочитали из файла")
    void getQuestions() throws NoFileWithQuestions {

        Commands questions = new CommandsImpl(properties);

        assertEquals(5, questions.getQuestions().size());
        assertEquals("это 1 вопрос", questions.getQuestions().get(0).getQuestion());
        assertEquals("ответ 1.1", questions.getQuestions().get(0).getAnswers().get(0));
        assertEquals(true, questions.getQuestions().get(0).getCorrectAnswers().get(0));
        assertEquals("ответ 1.2", questions.getQuestions().get(0).getAnswers().get(1));
        assertEquals(false, questions.getQuestions().get(0).getCorrectAnswers().get(1));
        assertEquals("ответ 1.3", questions.getQuestions().get(0).getAnswers().get(2));
        assertEquals(false, questions.getQuestions().get(0).getCorrectAnswers().get(2));
        assertEquals("ответ 1.4", questions.getQuestions().get(0).getAnswers().get(3));
        assertEquals(false, questions.getQuestions().get(0).getCorrectAnswers().get(3));
        assertEquals("ответ 1.5", questions.getQuestions().get(0).getAnswers().get(4));
        assertEquals(false, questions.getQuestions().get(0).getCorrectAnswers().get(4));

        assertEquals("это 2 вопрос", questions.getQuestions().get(1).getQuestion());
        assertEquals("ответ 2.1", questions.getQuestions().get(1).getAnswers().get(0));
        assertEquals(false, questions.getQuestions().get(1).getCorrectAnswers().get(0));
        assertEquals("ответ 2.2", questions.getQuestions().get(1).getAnswers().get(1));
        assertEquals(false, questions.getQuestions().get(1).getCorrectAnswers().get(1));
        assertEquals("ответ 2.3", questions.getQuestions().get(1).getAnswers().get(2));
        assertEquals(true, questions.getQuestions().get(1).getCorrectAnswers().get(2));
        assertEquals("ответ 2.4", questions.getQuestions().get(1).getAnswers().get(3));
        assertEquals(false, questions.getQuestions().get(1).getCorrectAnswers().get(3));

        assertEquals("это 3 вопрос", questions.getQuestions().get(2).getQuestion());
        assertEquals("ответ 3.1", questions.getQuestions().get(2).getAnswers().get(0));
        assertEquals(false, questions.getQuestions().get(2).getCorrectAnswers().get(0));
        assertEquals("ответ 3.2", questions.getQuestions().get(2).getAnswers().get(1));
        assertEquals(false, questions.getQuestions().get(2).getCorrectAnswers().get(1));
        assertEquals("ответ 3.3", questions.getQuestions().get(2).getAnswers().get(2));
        assertEquals(false, questions.getQuestions().get(2).getCorrectAnswers().get(2));
        assertEquals("ответ 3.4", questions.getQuestions().get(2).getAnswers().get(3));
        assertEquals(false, questions.getQuestions().get(2).getCorrectAnswers().get(3));
        assertEquals("ответ 3.5", questions.getQuestions().get(2).getAnswers().get(4));
        assertEquals(false, questions.getQuestions().get(0).getCorrectAnswers().get(4));

        assertEquals("это 4 вопрос", questions.getQuestions().get(3).getQuestion());
        assertEquals("ответ 4.1", questions.getQuestions().get(3).getAnswers().get(0));
        assertEquals(false, questions.getQuestions().get(3).getCorrectAnswers().get(0));
        assertEquals("ответ 4.2", questions.getQuestions().get(3).getAnswers().get(1));
        assertEquals(false, questions.getQuestions().get(0).getCorrectAnswers().get(1));

        assertEquals("это 5 вопрос", questions.getQuestions().get(4).getQuestion());
        assertEquals("ответ 5.1", questions.getQuestions().get(4).getAnswers().get(0));
        assertEquals(true, questions.getQuestions().get(4).getCorrectAnswers().get(0));
        assertEquals("ответ 5.2", questions.getQuestions().get(4).getAnswers().get(1));
        assertEquals(false, questions.getQuestions().get(4).getCorrectAnswers().get(1));
        assertEquals("ответ 5.3", questions.getQuestions().get(4).getAnswers().get(2));
        assertEquals(false, questions.getQuestions().get(4).getCorrectAnswers().get(2));

    }
}