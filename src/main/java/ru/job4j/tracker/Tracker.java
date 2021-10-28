package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker implements TaskTracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    @Override
    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    @Override
    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    @Override
    public Item findById(int id) {
        int indexFind = indexOf(id);
        return indexFind == -1 ? null : items[indexFind];
    }

    @Override
    public Item[] findByName(String key) {
        Item[] result = new Item[items.length];
        int count = 0;
        for (int i = 0; i < size; i++) {
            Item item = items[i];
            if (item != null
                    && item.getName().equals(key)) {
                result[count] = item;
                count++;
            }
        }
        result = Arrays.copyOf(result, count);
        return result;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index] != null
                    && items[index].getId() == id) {
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
        items[indexFind] = item;
        return true;
    }

    @Override
    public boolean delete(int id) {
        int indexFind = indexOf(id);
        if (indexFind == -1) {
            return false;
        }
        System.arraycopy(items, indexFind + 1, items, indexFind, size - indexFind - 1);
        items[size - 1] = null;
        size--;
        return true;
    }
}