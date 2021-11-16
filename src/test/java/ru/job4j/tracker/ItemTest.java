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
        int id = 0;
        Item one = new Item("Первая задача");
        one.setId(id);
        id++;
        Item two = new Item("Вторая задача");
        two.setId(id);
        id++;
        Item three = new Item("Третья задача");
        three.setId(id);
        List<Item> expected = Arrays.asList(two, one, three);
        List<Item> actual = Arrays.asList(one, two, three);
        Collections.sort(actual, new ItemAscByName());
        assertEquals(actual, expected);
    }

    @Test
    public void whenSortReverseByNmaneDesc() {
        int id = 0;
        Item one = new Item("Первая задача");
        one.setId(id);
        id++;
        Item two = new Item("Вторая задача");
        two.setId(id);
        id++;
        Item three = new Item("Третья задача");
        three.setId(id);
        List<Item> expected = Arrays.asList(three, one, two);
        List<Item> actual = Arrays.asList(one, two, three);
        Collections.sort(actual, new ItemDescByName());
        assertEquals(actual, expected);
    }

}