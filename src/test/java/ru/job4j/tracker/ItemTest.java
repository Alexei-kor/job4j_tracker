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
    public void whenSortById() {
        int id = 0;
        Item one = new Item("Первая задача");
        one.setId(id);
        id++;
        Item two = new Item("Вторая задача");
        two.setId(id);
        List<Item> list = Arrays.asList(one, two);
        Collections.sort(list);
        assertThat(list.get(0).getId(), is(0));
    }

    @Test
    public void whenSortReverseById() {
        int id = 0;
        Item one = new Item("Первая задача");
        one.setId(id);
        id++;
        Item two = new Item("Вторая задача");
        two.setId(id);
        List<Item> list = Arrays.asList(one, two);
        Collections.sort(list, new SortItem());
        assertThat(list.get(0).getId(), is(1));
    }

}