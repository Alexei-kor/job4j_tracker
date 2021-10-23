package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] itemWithoutNull = new Item[items.length];
        int sizeWithoutNull = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                itemWithoutNull[sizeWithoutNull] = items[i];
                sizeWithoutNull++;
            }
        }
        itemWithoutNull = Arrays.copyOf(itemWithoutNull, size);
        return itemWithoutNull;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findByName(String key) {
        Item[] itemFind = new Item[items.length];
        int sizeFind = 0;
        for (int i = 0; i < size; i++) {
            Item item = items[i];
            if (item.getName().equals(key)) {
                itemFind[sizeFind] = item;
                sizeFind++;
            }
        }
        itemFind = Arrays.copyOf(itemFind, sizeFind);
        return itemFind;
    }
}