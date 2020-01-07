package ru.chaban.ex3.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PropertiesTest {

    @Autowired
    private Properties properties;

    @Test
    void getTestFileName() {
        assertEquals("questions_ru_RU.csv", properties.getTestFileName());
    }

    @Test
    void getMinimumPositiveQuestionsForPassExam() {
        assertEquals(3, properties.getMinimumPositiveQuestionsForPassExam());
    }

    @Test
    void getMessageSource() {
        //english
        assertEquals("Question 1 from 1", properties.getMessageSource().getMessage("question.num", new String[]{"1", "1"}, new Locale("english")));
        assertEquals("Last Name and Name: ", properties.getMessageSource().getMessage("fio", null, new Locale("english")));
        assertEquals("Opption: ", properties.getMessageSource().getMessage("question.option", null, new Locale("english")));
        assertEquals("Your answer: ", properties.getMessageSource().getMessage("question.your.answer", null, new Locale("english")));
        assertEquals("Right!", properties.getMessageSource().getMessage("answer.right", null, new Locale("english")));
        assertEquals("Wrong!", properties.getMessageSource().getMessage("answer.wrong", null, new Locale("english")));
        assertEquals("Enter positive question", properties.getMessageSource().getMessage("answer.positive", null, new Locale("english")));
        assertEquals("Enter number from 1 to ", properties.getMessageSource().getMessage("answer.between", null, new Locale("english")));
        assertEquals("String can not be convert to num. Please enter numeric value", properties.getMessageSource().getMessage("answer.wrong.num", null, new Locale("english")));
        assertEquals("Correct answers 1 from 1", properties.getMessageSource().getMessage("test.right.answers", new String[]{"1", "1"}, new Locale("english")));
        assertEquals("In order to pass exam needs 1 correct answers", properties.getMessageSource().getMessage("test.correct", new String[]{"1"}, new Locale("english")));
        assertEquals("For pass exam you need 1 answers ", properties.getMessageSource().getMessage("test.condition", new String[]{"1"}, new Locale("english")));
        assertEquals("Test wrong, please, try again", properties.getMessageSource().getMessage("test.result.minus", null, new Locale("english")));
        assertEquals("You passed exam", properties.getMessageSource().getMessage("test.result.plus", null, new Locale("english")));

        //russian
        assertEquals("Вопрос 1 из 1", properties.getMessageSource().getMessage("question.num", new String[]{"1", "1"}, new Locale("ru_RU")));
        assertEquals("ФИО: ", properties.getMessageSource().getMessage("fio", null, new Locale("ru_RU")));
        assertEquals("Варианты: ", properties.getMessageSource().getMessage("question.option", null, new Locale("ru_RU")));
        assertEquals("Ваш ответ: ", properties.getMessageSource().getMessage("question.your.answer", null, new Locale("ru_RU")));
        assertEquals("Верно!", properties.getMessageSource().getMessage("answer.right", null, new Locale("ru_RU")));
        assertEquals("Ошибка!", properties.getMessageSource().getMessage("answer.wrong", null, new Locale("ru_RU")));
        assertEquals("Укажите положительное число", properties.getMessageSource().getMessage("answer.positive", null, new Locale("ru_RU")));
        assertEquals("Укажите  значение от 1 до ", properties.getMessageSource().getMessage("answer.between", null, new Locale("ru_RU")));
        assertEquals("Строка не соответствует формату числа. Укажите число", properties.getMessageSource().getMessage("answer.wrong.num", null, new Locale("ru_RU")));
        assertEquals("Верных ответов 1 из 1", properties.getMessageSource().getMessage("test.right.answers", new String[]{"1", "1"}, new Locale("ru_RU")));
        assertEquals("Для успешного прохождения теста необходимо ответить на 1 вопрос/а/ов ", properties.getMessageSource().getMessage("test.correct", new String[]{"1"}, new Locale("ru_RU")));
        assertEquals("Для прохождения теста потребовалось бы верно ответить еще на 1 вопрос/а/ов ", properties.getMessageSource().getMessage("test.condition", new String[]{"1"}, new Locale("ru_RU")));
        assertEquals("Тест завален, попробуйте еще раз", properties.getMessageSource().getMessage("test.result.minus", null, new Locale("ru_RU")));
        assertEquals("Тест успешно пройден", properties.getMessageSource().getMessage("test.result.plus", null, new Locale("ru_RU")));

    }

    @Test
    void getLocale() {
        assertEquals(new Locale("english"), properties.getLocale());
    }
}