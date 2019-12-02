package ru.chaban.spring.service;

import ru.chaban.spring.domain.Person;
import ru.chaban.spring.domain.QuestionAndAnswers;

import java.util.Scanner;

public class TestStudentImpl implements TestStudent {
    QuestionAndAnswers[] questionAndAnswers;

    public TestStudentImpl(GetQuestions getQuestions) {
        this.questionAndAnswers = getQuestions.getQuestions();
    }

    @Override
    public void testStudent() {

        Scanner inFio = new Scanner(System.in);
        System.out.print("ФИО: ");
        Person person = new Person(inFio.nextLine());

        int correctAnswers = 0;

        for (int i = 0; i < questionAndAnswers.length; i++) {
            System.out.println("Вопрос " + (i + 1) + " из "
                    + questionAndAnswers.length + " - \""
                    + questionAndAnswers[i].getQuestion() + "\"");
            System.out.println("Варианты:");

            for (int j = 0; j < questionAndAnswers[i].getAnswers().length; j++) {
                System.out.println("    " + (j + 1) + " - \"" + questionAndAnswers[i].getAnswers()[j] + "\"");
            }

            Integer numAnswer = null;

            while (true) {
                Scanner in = new Scanner(System.in);
                System.out.print("Ваш ответ: ");
                String strAnswer = in.nextLine();

                try {
                    numAnswer = Integer.parseInt(strAnswer);

                    if (numAnswer < 0) {
                        System.out.println("Укажите положительное число");
                        continue;
                    }

                    if (numAnswer > questionAndAnswers[i].getAnswers().length) {
                        System.out.println("Укажите  значение от 1 до " + questionAndAnswers[i].getAnswers().length);
                        continue;
                    }

                        if (questionAndAnswers[i].getCorrectAnswers()[numAnswer-1]) {
                            correctAnswers++;
                            System.out.println("Верно!");
                        }else {
                            System.out.println("Ошибка!");
                        }

                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Строка не соответствует формату числа. Укажите число");
                }

            }
        }
        System.out.println("Верных ответов " + correctAnswers + " из " + questionAndAnswers.length);
    }
}
