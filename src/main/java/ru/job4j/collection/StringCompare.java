package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int len = Math.min(right.length(), left.length());
        for (int i = 0; i < len; i++) {
            char l = left.charAt(i);
            char r = right.charAt(i);
            if (l != r) {
                return Character.compare(l, r);
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}
