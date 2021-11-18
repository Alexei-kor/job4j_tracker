package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        for (int i = 0; i < Math.min(left.length(), right.length()); i++) {
            char symL = left.charAt(i);
            char symR = right.charAt(i);

            if (symL != symR) {
                return Character.compare(symL, symR);
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}
