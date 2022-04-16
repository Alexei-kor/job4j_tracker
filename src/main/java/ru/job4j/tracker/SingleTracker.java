package ru.job4j.tracker;

import java.util.List;

public final class SingleTracker implements TaskTracker {
    private static SingleTracker instance = null;
    private MemTracker memTracker = new MemTracker();

    private SingleTracker() {

    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    @Override
    public Item add(Item item) {
        return memTracker.add(item);
    }

    @Override
    public List<Item> findAll() {
        return memTracker.findAll();
    }

    @Override
    public Item findById(int id) {
        return memTracker.findById(id);
    }

    @Override
    public List<Item> findByName(String key) {
        return memTracker.findByName(key);
    }

    @Override
    public boolean replace(int id, Item item) {
        return memTracker.replace(id, item);
    }

    @Override
    public boolean delete(int id) {
        return memTracker.delete(id);
    }
}
