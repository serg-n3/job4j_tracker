package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    private int index(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {

                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = index(id);
        return index != -1 ? items.get(index) : null;
    }

    public boolean replace(int id, Item item) {
        int index = index(id);
        boolean rls = index != -1;
        if (rls) {
            item.setId(id);
            items.set(index, item);
        }
        return rls;
    }

    public List<Item> findAll() {
        return List.copyOf(items);
    }

    public List<Item> findByName(String key) {
        List<Item> check  = new ArrayList<>();
        for (Item it : items) {
            if (it.getName().equals(key)) {
                check.add(it);
            }
        }
        return check;
    }

    public boolean delete(int id) {
        int index = index(id);
        boolean rls = index != -1;
        if (rls) {
            items.remove(index);
        }
        return rls;
    }
}
