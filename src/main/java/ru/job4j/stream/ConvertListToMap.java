package ru.job4j.stream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertListToMap {
    public static Map<String, Student> convert(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(Student::getSurname, a -> a, (a, b) -> a));
    }
}
