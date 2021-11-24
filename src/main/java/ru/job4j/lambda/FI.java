package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FI {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("дв", "р", "три", "четыре");
        Comparator<String> comparator = (o1, o2) -> o2.compareTo(o1);
        list.sort(comparator);
        System.out.println(list);
        Comparator<String> comparator2 = (o1, o2) -> Integer.compare(o2.length(), o1.length());
        list.sort(comparator2);
        System.out.println(list);
    }
}
