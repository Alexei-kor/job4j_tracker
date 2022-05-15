package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemTracker implements TaskTracker, Store, AutoCloseable {
    private final List<Item> items = new ArrayList<Item>();
    private int ids = 1;

    @Override
    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    @Override
    public List<Item> findAll() {
        return List.copyOf(items);
    }

    @Override
    public Item findById(int id) {
        int indexFind = indexOf(id);
        return indexFind == -1 ? null : items.get(indexFind);
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<Item>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    @Override
    public boolean replace(int id, Item item) {
        int indexFind = indexOf(id);
        if (indexFind == -1) {
            return false;
        }
        item.setId(id);
        items.set(indexFind, item);
        return true;
    }

    @Override
    public boolean delete(int id) {
        int indexFind = indexOf(id);
        if (indexFind == -1) {
            return false;
        }
        items.remove(indexFind);
        return true;
    }

    @Override
    public void close() throws Exception {

    }
}