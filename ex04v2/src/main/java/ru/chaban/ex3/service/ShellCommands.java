package ru.chaban.ex3.service;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.chaban.ex3.Exceptions.NoFileWithQuestions;
import ru.chaban.ex3.domain.Person;
import ru.chaban.ex3.domain.Questions;
import ru.chaban.ex3.domain.Test;

import java.util.HashMap;
import java.util.Map;

@ShellComponent
public class ShellCommands {

    // тест
    private Test test;

    // вопросы теста
    final private Commands commands;

    // ответы пользователя
    private Map<Integer, Integer> userAnswers = new HashMap<>();

    // настройки приложения
    final private Properties properties;

    public ShellCommands(Commands commands, Properties properties) {
        this.commands = commands;
        this.properties = properties;
    }

    @ShellMethod("Приветствие")
    public String hi() {
        return "Доброго времени суток. Представтесь, пожалуйста (для продолженя выполните fio)";
    }

    @ShellMethod("Меня зовут [ФИО] (для продолжения выполните list)")
    public String fio(String name) throws NoFileWithQuestions {
        // тест
        test = new Test(new Person(name), new Questions(commands));
        return "Приятно познакомиться, " + test.getPerson().getName();
    }

    @ShellMethod("Список оставшшихся вопросов")
    public String list() {
        String msg = "";

        for (int i = 0; i < test.getQuestions().size(); i++) {
            // покажем только вопросы на которые отсутствуют ответы
            if (!userAnswers.containsKey(i)) {
                // вопросы к тесту
                msg += properties.getMessageSource().getMessage("question.num", new String[]{
                        Integer.toString(i + 1),
                        test.getQuestions().size() + " - "
                                + test.getQuestions().get(i).getQuestion()
                }, properties.getLocale()) + "\n";

                // предполагаемые ответы
                for (int j = 0; j < test.getQuestions().get(i).getAnswers().size(); j++) {
                    msg += "\t" + (j + 1) + " - \"" + test.getQuestions().get(i).getAnswers().get(j) + "\" " + "\n";
                }
            }
        }

        return "Список вопросов \n" + msg;
    }

    @ShellMethod("Ответить на вопрос  [номер вопроса] [номер ответа]")
    public String answer(int numOfQuestion, int numAnswer) {

        String msg = "";

        if (numAnswer < 0) {
            msg += properties.getMessageSource().getMessage(
                    "answer.positive",
                    null,
                    properties.getLocale()) + "\n";
        }

        if (numAnswer > test.getQuestions().get(numOfQuestion - 1).getAnswers().size()) {
            msg += properties.getMessageSource().getMessage(
                    "answer.between",
                    new String[]{Integer.toString(test.getQuestions().get(numOfQuestion - 1).getAnswers().size())},
                    properties.getLocale()) + "\n";
        }

        // Сохраним ответ пользователя
        userAnswers.put(numOfQuestion - 1, numAnswer - 1);

        // проверим корректность ответа
        msg += test.getAnswer(
                test.getQuestions().get(numOfQuestion - 1).getCorrectAnswers().get(numAnswer - 1),
                properties.getMessageSource(),
                properties.getLocale()) + "\n";

        return msg;
    }

    @ShellMethod("Результаты теста")
    public String result() {
        String msg = "";

        msg += properties.getMessageSource().getMessage(
                "test.right.answers",
                new String[]{Integer.toString(test.getCorrectAnswers()),
                        Integer.toString(test.getQuestions().size())},
                properties.getLocale()
        ) + "\n";

        msg += properties.getMessageSource().getMessage(
                "test.correct",
                new String[]{Integer.toString(properties.getMinimumPositiveQuestionsForPassExam())},
                properties.getLocale()) + "\n";

        if (test.getCorrectAnswers() >= properties.getMinimumPositiveQuestionsForPassExam()) {
            msg += properties.getMessageSource().getMessage("test.result.plus", null, properties.getLocale());
        } else {
            msg +=
                    properties.getMessageSource().getMessage("test.condition",
                            new String[]{Integer.toString((properties.getMinimumPositiveQuestionsForPassExam()
                                    - test.getCorrectAnswers()))},
                            properties.getLocale()) + "\n";
            msg += properties.getMessageSource().getMessage(
                    "test.result.minus",
                    null,
                    properties.getLocale()) + "\n";
        }
        return msg;
    }
}
