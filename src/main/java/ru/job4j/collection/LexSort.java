package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] arrL = left.split("\\.");
        String[] arrR = right.split("\\.");
        return Integer.compare(Integer.parseInt(arrL[0]), Integer.parseInt(arrR[0]));
    }
}
