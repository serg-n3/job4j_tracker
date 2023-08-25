package ru.job4j.tracker;

import java.util.Comparator;

public class SortDescByNameJob1 implements Comparator<Job1> {
    @Override
    public int compare(Job1 left, Job1 right) {
        return right.getName().compareTo(left.getName());
    }
}
