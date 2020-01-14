package ru.chaban.ex3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import ru.chaban.ex3.Exceptions.NoFileWithQuestions;
import ru.chaban.ex3.service.TestStudent;
import ru.chaban.ex3.service.TestStudentImpl;

@SpringBootApplication
public class Ex3Application {

    public static void main(String[] args) throws NoFileWithQuestions {
        ConfigurableApplicationContext context = SpringApplication.run(Ex3Application.class, args);
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("bundle");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }
}
