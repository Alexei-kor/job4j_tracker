package ru.job4j.tracker;

import java.util.List;

public interface TaskTracker {
    Item add(Item item);

    List<Item> findAll();

    Item findById(int id);

    List<Item> findByName(String key);

    boolean replace(int id, Item item);

    boolean delete(int id);
}
