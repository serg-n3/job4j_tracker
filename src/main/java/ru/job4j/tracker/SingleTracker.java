package ru.job4j.tracker;

import java.util.List;

public class SingleTracker {
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

    public Item add(Item item) {
        return memTracker.add(item);
    }

    public Item findById(int id) {
        return memTracker.findById(id);
    }

    public List<Item> findAll() {
        return memTracker.findAll();
    }

    public List<Item> findByName(String key) {
        return memTracker.findByName(key);
    }

    public boolean replace(int id, Item tack) {
        return memTracker.replace(id, tack);
    }

    public void delete(int id) {
         memTracker.delete(id);
    }
}

