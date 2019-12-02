package ru.chaban.spring.service;

import ru.chaban.spring.domain.QuestionAndAnswers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GetQuestionsImpl implements GetQuestions {

    public GetQuestionsImpl() {
    }

    @Override
    public QuestionAndAnswers[] getQuestions() {
        QuestionAndAnswers[] questionAndAnswers = null;

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("questions.csv");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line ;
        int lineNumber = 0;
        int countOfQuestions = -1;
        int indexOfQuestion = -1;
        int countOfAnswers = -1;
        int indexOfAnswers = -1;

        String question = "";
        List<String> answers = new ArrayList<>();
        List<Boolean> correctAnswers = new ArrayList<>();

        boolean isQuestion = true;
        try {
            while ((line = bufferedReader.readLine()) != null) {

                //System.out.println(line);

                // в первой строке содежрится количество вопросов
                if (lineNumber == 0) {
                    countOfQuestions = Integer.parseInt(line);
                    questionAndAnswers = new QuestionAndAnswers[countOfQuestions];
                }
                // последующие стртоки содержат вопросы с количеством ответов и ответы
                else {
                    if (indexOfQuestion == -1) {
                        indexOfQuestion++;
                        isQuestion = true;
                    }

                    String[] splitLine = line.split(",");

                    // ответы
                    if (!isQuestion) {
                        indexOfAnswers++;
                        answers.add(splitLine[0].trim());
                        correctAnswers.add(Boolean.parseBoolean(splitLine[1].trim()));
                    }

                    // вопросы
                    if (isQuestion) {
                        question = splitLine[0].trim();
                        countOfAnswers = Integer.parseInt(splitLine[1].trim());
                        isQuestion = false;
                    }

                    // сохраним
                    if (countOfAnswers - 1 == indexOfAnswers && countOfAnswers != -1) {
                        questionAndAnswers[indexOfQuestion] =
                                new QuestionAndAnswers(question,
                                        answers.toArray(new String[countOfAnswers - 1]),
                                        correctAnswers.toArray(new Boolean[countOfAnswers - 1]));
                        indexOfQuestion++;
                        isQuestion = true;

                        // обнулим
                        question = "";
                        answers.clear();
                        correctAnswers.clear();
                        indexOfAnswers = -1;
                    }
                }

                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return questionAndAnswers;
    }
}