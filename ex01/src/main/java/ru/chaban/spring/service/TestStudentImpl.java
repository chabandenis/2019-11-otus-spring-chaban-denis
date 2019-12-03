package ru.chaban.spring.service;

import ru.chaban.spring.domain.Person;
import ru.chaban.spring.domain.QuestionAndAnswers;

import java.util.List;
import java.util.Scanner;

public class TestStudentImpl implements TestStudent {
    GetQuestions getQuestions;

    public TestStudentImpl(GetQuestions getQuestions) {
        this.getQuestions = getQuestions;
    }

    @Override
    public void testStudent() {

        Scanner inFio = new Scanner(System.in);
        System.out.print("ФИО: ");
        Person person = new Person(inFio.nextLine());

        int correctAnswers = 0;

        for (int i = 0; i < getQuestions.getQuestions().size(); i++) {
            System.out.println("Вопрос " + (i + 1) + " из "
                    + getQuestions.getQuestions().size() + " - \""
                    + getQuestions.getQuestions().get(i).getQuestion() + "\"");
            System.out.println("Варианты:");

            for (int j = 0; j < getQuestions.getQuestions().get(i).getAnswers().size(); j++) {
                System.out.println("    " + (j + 1) + " - \"" + getQuestions.getQuestions().get(i).getAnswers().get(j) + "\"");
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

                    if (numAnswer > getQuestions.getQuestions().get(i).getAnswers().size()) {
                        System.out.println("Укажите  значение от 1 до " + getQuestions.getQuestions().get(i).getAnswers().size());
                        continue;
                    }

                    if (getQuestions.getQuestions().get(i).getCorrectAnswers().get(numAnswer - 1)) {
                        correctAnswers++;
                        System.out.println("Верно!");
                    } else {
                        System.out.println("Ошибка!");
                    }

                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Строка не соответствует формату числа. Укажите число");
                }
            }
        }
        System.out.println("Верных ответов " + correctAnswers + " из " + getQuestions.getQuestions().size());
    }
}
