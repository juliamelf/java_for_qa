package ru.juliamelf.javaqa.sandbox;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Julia on 6/14/2016.
 */
public class Collections {

    public static void main(String[] args) {

        List<String> languages = Arrays.asList("Java", "C#", "Python", "JavaScript");

        for (String l : languages) {
            System.out.println("Я хочу изучать " + l);
        }

    }
}
