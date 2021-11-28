package ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ConvertListToMapTest {

    @Test
    public void whenConvertListToMap() {
        Student std1 = new Student(10, "Surname1");
        Student std2 = new Student(30, "Surname3");
        Student std3 = new Student(40, "Surname4");
        Student std4 = new Student(50, "Surname3");
        Student std5 = new Student(60, "Surname6");
        Student std6 = new Student(70, "Surname1");
        Map<String, Student> actual = ConvertListToMap.convert(
                List.of(std1, std2, std3, std4, std5, std6));
        Map<String, Student> expected = Map.of(
                "Surname1", std6,
                "Surname3", std4,
                "Surname4", std3,
                "Surname6", std5
        );
        Assert.assertThat(actual, is(expected));
    }
}