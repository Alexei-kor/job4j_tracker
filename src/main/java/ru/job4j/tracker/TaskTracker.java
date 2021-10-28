package ru.job4j.tracker;

public interface TaskTracker {
    Item add(Item item);

    Item[] findAll();

    Item findById(int id);

    Item[] findByName(String key);

    boolean replace(int id, Item item);

    boolean delete(int id);
}
