package ru.javawebinar.basejava;

import java.util.stream.IntStream;

public class Stream {
    public static void main(String[] args) {
        IntStream.range(0, 10)
                .forEach(System.out::println);
    }
}
