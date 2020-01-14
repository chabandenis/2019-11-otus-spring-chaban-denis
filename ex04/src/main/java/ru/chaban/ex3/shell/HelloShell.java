package ru.chaban.ex3.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.chaban.ex3.Exceptions.NoFileWithQuestions;
import ru.chaban.ex3.domain.Person;
import ru.chaban.ex3.domain.Questions;
import ru.chaban.ex3.domain.Test;
import ru.chaban.ex3.service.GetQuestions;
import ru.chaban.ex3.service.Properties;

import java.util.Scanner;

@ShellComponent
public class HelloShell {

    // тест
    private Test test;

    // вопросы теста
    final private GetQuestions getQuestions;

    // настройки приложения
    final private Properties properties;

    public HelloShell(GetQuestions getQuestions, Properties properties) {
        this.getQuestions = getQuestions;
        this.properties = properties;
    }

    @ShellMethod("Приветствие")
    public String hi() {
        return "Доброго времени суток. Представтесь, пожалуйста (для продолженя выполните fio)";
    }

    @ShellMethod("Меня зовут [ФИО] (для продолжения выполните list)")
    public String fio(String name) throws NoFileWithQuestions {
        // тест
        test = new Test(new Person(name), new Questions(getQuestions));
        return "Приятно познакомиться, " + test.getPerson().getName();
    }

    @ShellMethod("Список вопросов")
    public String list() {
        String msg = "";

        for (int i = 0; i < test.getQuestions().size(); i++) {
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

        return "Список вопросов \n" + msg;
    }

    @ShellMethod("Ответить на вопрос  [номер вопроса]")
    public String answer(int numOfQuestion, int numAnswer) {

        String msg = "";

        if (numAnswer < 0) {
            msg += properties.getMessageSource().getMessage(
                    "answer.positive",
                    null,
                    properties.getLocale()) +"\n";
        }

        if (numAnswer > test.getQuestions().get(numOfQuestion-1).getAnswers().size()) {
            msg += properties.getMessageSource().getMessage(
                    "answer.between",
                    new String[]{Integer.toString(test.getQuestions().get(numOfQuestion-1).getAnswers().size())},
                    properties.getLocale()) +"\n";
        }

        // проверим корректность ответа
        msg +=test.getAnswer(
                test.getQuestions().get(numOfQuestion-1).getCorrectAnswers().get(numAnswer - 1),
                properties.getMessageSource(),
                properties.getLocale()) +"\n";

        return msg;
    }

    @ShellMethod("Результаты теста")
    public String result() {
        return "Пожалуйста";
    }


}
