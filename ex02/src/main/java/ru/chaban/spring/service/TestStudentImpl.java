package ru.chaban.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.core.Local;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.chaban.spring.Eexceptions.NoFileWithQuestions;
import ru.chaban.spring.domain.Person;

import java.util.Locale;
import java.util.Scanner;

@Service
public class TestStudentImpl implements TestStudent {
    private GetQuestions getQuestions;
    private MessageSource messageSource;
    private Locale locale;


    private final int minimumPositiveQuestionsForPassExam;

    @Autowired
    public TestStudentImpl(GetQuestions getQuestions,
                           @Value("${db.minimumPositivQuestionsForPassExam}") int minimumPositiveQuestionsForPassExam,
                           MessageSource messageSource,
                           @Value("${locale}") String localeStr
    ) {
        this.getQuestions = getQuestions;
        this.minimumPositiveQuestionsForPassExam = minimumPositiveQuestionsForPassExam;
        this.messageSource = messageSource;
        this.locale = new Locale(localeStr);
    }

    @Override
    public void testStudent() throws NoFileWithQuestions {

        Scanner inFio = new Scanner(System.in);
        System.out.print(messageSource.getMessage("fio", null, locale));
        Person person = new Person(inFio.nextLine());

        int correctAnswers = 0;

        for (int i = 0; i < getQuestions.getQuestions().size(); i++) {
            System.out.println(messageSource.getMessage("question.num", new String[]{
                    Integer.toString(i + 1),
                    getQuestions.getQuestions().size() + " - "
                            + getQuestions.getQuestions().get(i).getQuestion()
            }, locale));
            System.out.println(messageSource.getMessage("question.option", null, locale));

            for (int j = 0; j < getQuestions.getQuestions().get(i).getAnswers().size(); j++) {
                System.out.println("    " + (j + 1) + " - \"" + getQuestions.getQuestions().get(i).getAnswers().get(j) + "\"");
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

                    if (numAnswer > getQuestions.getQuestions().get(i).getAnswers().size()) {
                        System.out.println(messageSource.getMessage("answer.between",
                                new String[]{Integer.toString(getQuestions.getQuestions().get(i).getAnswers().size())},
                                locale));
                        continue;
                    }

                    if (getQuestions.getQuestions().get(i).getCorrectAnswers().get(numAnswer - 1)) {
                        correctAnswers++;
                        System.out.println(messageSource.getMessage("answer.right", null, locale));
                    } else {
                        System.out.println(messageSource.getMessage("answer.wrong", null, locale));
                    }

                    break;
                } catch (NumberFormatException e) {
                    System.out.println(messageSource.getMessage("answer.wrong.num", null, locale));
                }
            }
        }
        System.out.println(messageSource.getMessage("test.right.answers", new String[]{Integer.toString(correctAnswers), Integer.toString(getQuestions.getQuestions().size())}, locale)
        );

        System.out.println(messageSource.getMessage("test.correct", new String[]{Integer.toString(minimumPositiveQuestionsForPassExam)}, locale));

        if (correctAnswers >= minimumPositiveQuestionsForPassExam) {
            System.out.println(messageSource.getMessage("test.result.plus", null, locale));
        } else {
            System.out.println(
                    messageSource.getMessage("test.condition", new String[]{Integer.toString((minimumPositiveQuestionsForPassExam - correctAnswers))}, locale));
            System.out.println(messageSource.getMessage("test.result.minus", null, locale));
        }
    }
}
