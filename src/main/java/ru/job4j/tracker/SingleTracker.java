package ru.job4j.tracker;

public class SingleTracker {
    private static SingleTracker instance = null;
    private Tracker tracker = new Tracker();

    private SingleTracker() {
    }

    public SingleTracker getSingleTracker() {
        if (instance == null) {
            return new SingleTracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public Item[] findByName(String key) {
        return tracker.findByName(key);
    }

    public boolean replace(int id, Item tack) {
        return tracker.replace(id, tack);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }
}

