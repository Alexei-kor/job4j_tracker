package ru.job4j.collection;

import java.util.ArrayList;

public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("One");
        arrayList.add("Two");
        arrayList.add("Three");

        for (String el: arrayList) {
            System.out.println(el);
        }
    }
}
