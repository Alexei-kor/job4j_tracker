package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {

    @Override
    public int compare(String dep1, String dep2) {
        String[] arr1 = dep1.split("/");
        String[] arr2 = dep2.split("/");
        int rsl = arr2[0].compareTo(arr1[0]);
        return rsl == 0 ? dep1.compareTo(dep2) : arr2[0].compareTo(arr1[0]);
    }
}
