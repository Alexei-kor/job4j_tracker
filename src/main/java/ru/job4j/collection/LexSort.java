package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        left = left.replaceAll("[^0-9.]", "");
        right = right.replaceAll("[^0-9.]", "");
        String[] arrL = left.split("\\.");
        String[] arrR = right.split("\\.");
        for (int i = 0; i < Math.min(arrL.length, arrR.length); i++) {
            int numL = Integer.parseInt(arrL[i]);
            int numR = Integer.parseInt(arrR[i]);
            if (numL != numR) {
                return numL - numR;
            }
        }
        return arrL.length - arrR.length;
    }
}
