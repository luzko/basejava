package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.SectionType;

public class TestSingleton {
    private static TestSingleton ourInstance = new TestSingleton();

    public static TestSingleton getInstance() {
        return ourInstance;
    }

    private TestSingleton() {

    }

    public static void main(String[] args) {
        for (SectionType type : SectionType.values()) {
            System.out.println(type.getTitle());
        }
    }
}
