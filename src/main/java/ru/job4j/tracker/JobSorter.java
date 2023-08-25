package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JobSorter {
    public static void main(String[] args) {
        List<Job1> jobs = Arrays.asList(
                new Job1("Fix bugs", 4),
                new Job1("Impl task", 2),
                new Job1("Reboot server", 1)
        );
        System.out.println(jobs);
        Collections.sort(jobs);
        System.out.println(jobs);
    }
}