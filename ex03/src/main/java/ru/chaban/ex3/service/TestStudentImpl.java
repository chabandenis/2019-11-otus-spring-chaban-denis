package ru.chaban.ex3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.chaban.ex3.domain.Person;
import ru.chaban.ex3.domain.Questions;
import ru.chaban.ex3.domain.Test;
import java.util.Scanner;

/*
    Сервис проведения тестирования
 */
@Service
public class TestStudentImpl implements TestStudent {

    // вопросы теста
    final private GetQuestions getQuestions;

    // настройки приложения
    final private Properties properties;

    @Autowired
    public TestStudentImpl(Properties properties,
                           GetQuestions getQuestions) {
        this.properties = properties;
        this.getQuestions = getQuestions;
    }

    private void msg(String codeMsg, String msg) {
        System.out.println(properties.getMessageSource().getMessage(
                codeMsg,
                new String[]{msg},
                properties.getLocale())
        );
    }

    // итоговый результат теста
    private void results(Test test) {

        System.out.println(properties.getMessageSource().getMessage(
                "test.right.answers",
                new String[]{Integer.toString(test.getCorrectAnswers()),
                        Integer.toString(test.getQuestions().size())},
                properties.getLocale()
        ));

        msg("test.correct",
                Integer.toString(properties.getMinimumPositiveQuestionsForPassExam()));

        if (test.getCorrectAnswers() >= properties.getMinimumPositiveQuestionsForPassExam()) {
            msg("test.result.plus", null);
        } else {
            System.out.println(
                    properties.getMessageSource().getMessage("test.condition",
                            new String[]{Integer.toString((properties.getMinimumPositiveQuestionsForPassExam()
                                    - test.getCorrectAnswers()))},
                            properties.getLocale()));
            msg("test.result.minus", null);
        }

    }

    @Override
    public void testStudent() {

        Scanner inFio = new Scanner(System.in);
        System.out.print(properties.getMessageSource().getMessage("fio", null, properties.getLocale()));
        Person person = new Person(inFio.nextLine());

        // создать тест
        Test test = new Test(person, new Questions(getQuestions));

        // ввод вопросов
        for (int i = 0; i < test.getQuestions().size(); i++) {
            System.out.println(properties.getMessageSource().getMessage("question.num", new String[]{
                    Integer.toString(i + 1),
                    test.getQuestions().size() + " - "
                            + test.getQuestions().get(i).getQuestion()
            }, properties.getLocale()));
            msg("question.option", null);

            for (int j = 0; j < test.getQuestions().get(i).getAnswers().size(); j++) {
                System.out.println("    " + (j + 1) + " - \"" + test.getQuestions().get(i).getAnswers().get(j) + "\"");
            }

            Integer numAnswer;

            while (true) {
                Scanner in = new Scanner(System.in);
                System.out.print(properties.getMessageSource().getMessage("question.your.answer", null, properties.getLocale()));
                String strAnswer = in.nextLine();

                try {
                    numAnswer = Integer.parseInt(strAnswer);

                    if (numAnswer < 0) {
                        msg("answer.positive", null);
                        continue;
                    }

                    if (numAnswer > test.getQuestions().get(i).getAnswers().size()) {
                        msg("answer.between",
                                Integer.toString(test.getQuestions().get(i).getAnswers().size()));
                        continue;
                    }

                    // проверим корректность ответа
                    test.getAnswer(
                            test.getQuestions().get(i).getCorrectAnswers().get(numAnswer - 1),
                            properties.getMessageSource(),
                            properties.getLocale());

                    break;
                } catch (NumberFormatException e) {
                    msg("answer.wrong.num", null);
                }
            }
        }

        // результаты теста
        results(test);
    }
}
