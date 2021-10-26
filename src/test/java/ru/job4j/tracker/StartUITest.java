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
        new CreateItem().execute(input, tracker);
        Item expected = new Item("первая");
        Item actual = tracker.findAll()[0];
        assertThat(actual.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()),
                "replaced item"
        };
        new EditItem().execute(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {String.valueOf(item.getId())};
        new DeleteItem().execute(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertNull(replaced);
    }

}