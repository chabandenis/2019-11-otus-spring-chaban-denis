package ru.chaban.ex3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.chaban.ex3.Eexceptions.NoFileWithQuestions;
import ru.chaban.ex3.domain.Person;
import ru.chaban.ex3.domain.Questions;
import ru.chaban.ex3.domain.Test;

import java.util.Locale;
import java.util.Scanner;

@Service
public class TestStudentImpl implements TestStudent {
    private GetQuestions getQuestions;

    // настройки приложения
    final private Properties properties;

    @Autowired
    public TestStudentImpl(Properties properties) {
        this.properties = properties;
    }

    @Autowired
/*    public TestStudentImpl(GetQuestions getQuestions,
                           @Value("${db.minimumPositivQuestionsForPassExam}") int minimumPositiveQuestionsForPassExam,
                           MessageSource messageSource,
                           @Value("${locale}") String localeStr
    )
{
        this.getQuestions = getQuestions;
        this.minimumPositiveQuestionsForPassExam = minimumPositiveQuestionsForPassExam;
        this.messageSource = messageSource;
        this.locale = new Locale(localeStr);
    }

 */

    @Override
    public void testStudent() {
        System.out.println("results_for_test " + properties.getLocale() + ", " + properties.getMessageSource() + ", " + properties.getMinimumPositiveQuestionsForPassExam() + ", " + properties.getTestFileName());
/*
        Scanner inFio = new Scanner(System.in);
        System.out.print(messageSource.getMessage("fio", null, locale));
        Person person = new Person(inFio.nextLine());

        // создать тест
        Test test = new Test(person, new Questions(getQuestions));

        // ввод вопросов
        for (int i = 0; i < test.getQuestions().size(); i++) {
            System.out.println(messageSource.getMessage("question.num", new String[]{
                    Integer.toString(i + 1),
                    test.getQuestions().size() + " - "
                            + test.getQuestions().get(i).getQuestion()
            }, locale));
            System.out.println(messageSource.getMessage("question.option", null, locale));

            for (int j = 0; j < test.getQuestions().get(i).getAnswers().size(); j++) {
                System.out.println("    " + (j + 1) + " - \"" + test.getQuestions().get(i).getAnswers().get(j) + "\"");
            }

            Integer numAnswer = null;

            while (true) {
                Scanner in = new Scanner(System.in);
                System.out.print(messageSource.getMessage("question.your.answer", null, locale));
                String strAnswer = in.nextLine();

                try {
                    numAnswer = Integer.parseInt(strAnswer);

                    if (numAnswer < 0) {
                        System.out.println(messageSource.getMessage("answer.positive", null, locale));
                        continue;
                    }

                    if (numAnswer > test.getQuestions().get(i).getAnswers().size()) {
                        System.out.println(messageSource.getMessage("answer.between",
                                new String[]{Integer.toString(test.getQuestions().get(i).getAnswers().size())},
                                locale));
                        continue;
                    }

                    // проверим корректность ответа
                    test.getAnswer(
                            test.getQuestions().get(i).getCorrectAnswers().get(numAnswer - 1),
                            messageSource,
                            locale);

                    break;
                } catch (NumberFormatException e) {
                    System.out.println(messageSource.getMessage("answer.wrong.num", null, locale));
                }
            }
        }

        // результаты теста
        test.results(messageSource, locale);

 */
    }
}
