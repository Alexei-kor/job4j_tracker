package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class LexSortTest {

    @Test
    public void sortNum1and2and10() {
        String[] input = {
                "10. Task.",
                "1. Task.",
                "2. Task."
        };
        String[] out = {
                "1. Task.",
                "2. Task.",
                "10. Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input, is(out));
    }

    @Test
    public void whenVeryDifficultTest() {
        String[] input = {
                "6.4. Десять",
                "6.2. Пять",
                "6.0.2. Два",
                "6.0.1. Раз",
                "6.0.3. Три",
                "6.1. Четыре",
                "6.2.2. Семь",
                "6.2.1. Шесть",
                "6.3. Девять",
                "6.2.3. Восемь",
                "6.4.1. Одиннадцать"
        };
        String[] out = {
                "6.0.1. Раз",
                "6.0.2. Два",
                "6.0.3. Три",
                "6.1. Четыре",
                "6.2. Пять",
                "6.2.1. Шесть",
                "6.2.2. Семь",
                "6.2.3. Восемь",
                "6.3. Девять",
                "6.4. Десять",
                "6.4.1. Одиннадцать"
        };
        Arrays.sort(input, new LexSort());
        assertThat(input, is(out));
    }

}