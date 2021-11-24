package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("р", "дв", "три", "четыре");
        System.out.println("Упорядочивание строк по убыванию");
        Comparator<String> comparator = (o1, o2) -> {
            System.out.println("Строка 1: " + o1 + System.lineSeparator() + "Строка 2: " + o2);
            int rsl = o2.compareTo(o1);
            System.out.println(rsl < 0 ? "Строка 1 больше Строки 2"
                    : rsl == 0 ? "Строки равны" : "Строка 1 меньше строки 2");
            return rsl;
        };
        list.sort(comparator);
        System.out.println(list);
    }
}
