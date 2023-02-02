package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] zahlen = new int[]{9, 1, 8, 2, 7, 3, 6, 4, 5};

        //Aufgabe1
        Arrays.stream(zahlen)
                .sorted()
                .forEach(number -> System.out.println(number));

        //Aufgabe2
        int sumResult = Arrays.stream(zahlen).sum();
        System.out.println(sumResult);

        //Aufgabe3
        int multiplyResult = Arrays.stream(zahlen)
                .reduce(1, (a, b) -> a * b);
        System.out.println(multiplyResult);

        //Aufgabe4
        Files.lines(Path.of("src/main/resources/students.csv"))
                .forEach(lines -> System.out.println(lines));

        //Aufgabe5
        Files.lines(Path.of("src/main/resources/students.csv"))
                .skip(1)
                .forEach(line -> System.out.println(line));

        //Aufgabe 6 / 7
        List<Student> studentList = Files.lines(Path.of("src/main/resources/students.csv"))
                .skip(1)
                .filter(line -> !line.isEmpty())
                .distinct()
                .map(line -> {
                    String[] split = line.split(",", 4);
                    return new Student(split[0], split[1], split[2], split[3]);
                })
                .toList();

        studentList.stream()
                .forEach(student -> System.out.println(student));
    }


}
