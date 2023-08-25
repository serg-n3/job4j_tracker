package ru.job4j.tracker;

import java.util.Comparator;

public class SortByNameJob1 implements Comparator<Job1> {
    @Override
    public int compare(Job1 left, Job1 right) {
        return left.getName().compareTo(right.getName());
    }
}
