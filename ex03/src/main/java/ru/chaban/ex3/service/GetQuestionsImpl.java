package ru.chaban.ex3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.chaban.ex3.domain.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
    Сервис получения актупльного списка вопросов
 */
@Service
public class GetQuestionsImpl implements GetQuestions {
    // свойства с которыми запустилось приложение
    private final Properties properties;

    @Autowired
    public GetQuestionsImpl(Properties properties) {
        this.properties = properties;
    }

    @Override
    public List<Question> getQuestions()  {

        List<Question> questionAndAnswers = new ArrayList<>();

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(properties.getTestFileName());

        if (inputStream == null) {
            System.out.println("Файл \"" + properties.getTestFileName() + "\" вопросами не найден. Выберите существующий");
            return null;
            //throw new NoFileWithQuestions("Файл \"" + testFileName + " \" вопросами не найден. Выберите существующий");
        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        int lineNumber = 0;
        int countOfQuestions = -1;
        int indexOfQuestion = -1;
        int countOfAnswers = -1;
        int indexOfAnswers = -1;

        String question = "";

        List<String> answers = null;
        List<Boolean> correctAnswers = null;

        boolean isQuestion = true;
        try {
            while ((line = bufferedReader.readLine()) != null) {

                // в первой строке содежрится количество вопросов
                if (lineNumber == 0) {
                    countOfQuestions = Integer.parseInt(line);
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
                        answers = new ArrayList<>();
                        correctAnswers = new ArrayList<>();
                    }

                    // сохраним
                    if (countOfAnswers - 1 == indexOfAnswers && countOfAnswers != -1) {
                        questionAndAnswers.add(new Question(question, answers, correctAnswers));
                        indexOfQuestion++;
                        isQuestion = true;

                        // обнулим
                        question = "";
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