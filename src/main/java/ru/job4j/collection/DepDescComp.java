package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {

    @Override
    public int compare(String dep1, String dep2) {
        String[] arr1 = dep1.split("/");
        String[] arr2 = dep2.split("/");
        int tmp1 = Integer.parseInt(arr1[0].replaceAll("[^0-9]", ""));
        int tmp2 = Integer.parseInt(arr2[0].replaceAll("[^0-9]", ""));
        if (tmp1 == tmp2) {
            for (int i = 1; i < Math.min(arr1.length, arr2.length); i++) {
                tmp1 = Integer.parseInt(arr1[i].replaceAll("[^0-9]", ""));
                tmp2 = Integer.parseInt(arr2[i].replaceAll("[^0-9]", ""));
                if (tmp1 != tmp2) {
                    return Integer.compare(tmp1, tmp2);
                }
            }
            return Integer.compare(arr1.length, arr2.length);
        } else {
            return Integer.compare(tmp2, tmp1);
        }
    }
}
