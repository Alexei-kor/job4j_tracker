package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        for (int i = 0; i < Math.min(left.length(), right.length()); i++) {
            char symL = left.toCharArray()[i];
            char symR = right.toCharArray()[i];
            if (symL != symR) {
                return symL - symR;
            }
        }
        return left.length() - right.length();
    }
}
