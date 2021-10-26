package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class StartUITest {

    @Test
    public void createItem() {
        String[] answers = new String[]{"первая", "вторая", "третья"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item expected = new Item("первая");
        Item actual = tracker.findAll()[0];
        assertThat(actual.getName(), is(expected.getName()));
    }
}