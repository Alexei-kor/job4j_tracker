package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("ivanov@expample.com", "Ivanov");
        map.put("petrov@expample.com", "Petrov");
        map.put("sidorov@expample.com", "Sidorov");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " / " + entry.getValue());
        }
    }
}
