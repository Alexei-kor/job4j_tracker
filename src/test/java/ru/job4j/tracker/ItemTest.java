package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ItemTest {

    @Test
    public void whenSortByNameAsc() {
        Item one = new Item(0, "Первая задача");
        Item two = new Item(1, "Вторая задача");
        Item three = new Item(2, "Третья задача");
        List<Item> expected = Arrays.asList(two, one, three);
        List<Item> actual = Arrays.asList(one, two, three);
        Collections.sort(actual, new ItemAscByName());
        assertEquals(actual, expected);
    }

    @Test
    public void whenSortReverseByNmaneDesc() {
        Item one = new Item(0, "Первая задача");
        Item two = new Item(1, "Вторая задача");
        Item three = new Item(2, "Третья задача");
        List<Item> expected = Arrays.asList(three, one, two);
        List<Item> actual = Arrays.asList(one, two, three);
        Collections.sort(actual, new ItemDescByName());
        assertEquals(actual, expected);
    }

}