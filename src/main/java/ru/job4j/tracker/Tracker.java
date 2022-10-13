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

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public boolean replace(int id, Item item) {
        boolean rls = indexOf(id) != -1;
        if (rls) {
            int index = indexOf(id);
            item.setId(id);
            items[index] = item;
        }
        return rls;
    }

    public Item[] findAll() {
        return  Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[items.length];
        int count = 0;
        for (int index = 0; index < size; index++) {
            Item name = items[index];
            if (name.getName().equals(key)) {
                rsl[count] = name;
                count++;
            }
        }
        return  Arrays.copyOf(rsl, count);
    }
}
