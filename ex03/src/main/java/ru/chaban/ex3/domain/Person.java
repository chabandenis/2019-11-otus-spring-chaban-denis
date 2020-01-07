/*
    Данные о пользователе, который проходит тест
 */

package ru.chaban.ex3.domain;

public class Person {
    private String Name;

    public Person(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }
}
