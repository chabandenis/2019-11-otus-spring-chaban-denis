package ru.chaban.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.chaban.spring.Eexceptions.NoFileWithQuestions;
import ru.chaban.spring.service.TestStudent;
import ru.chaban.spring.service.TestStudentImpl;

@ComponentScan
@Configuration
@PropertySource("classpath:application.properties")

public class Example {

    public static void main(String[] args) throws NoFileWithQuestions {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Example.class);
        TestStudent testStudent = context.getBean(TestStudentImpl.class);

        testStudent.testStudent();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("bundle");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }
}
