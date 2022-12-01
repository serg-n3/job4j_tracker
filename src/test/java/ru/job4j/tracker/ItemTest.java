package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class ItemTest {

    @Test
    public void comparableSort() {
        List<Item> items = Arrays.asList(
                new Item(1, "One"),
                new Item(8, "Eight"),
                new Item(2, "Two")
        );
        Collections.sort(items);
        List<Item> expected = Arrays.asList(
                new Item(1, "One"),
                new Item(2, "Two"),
                new Item(8, "Eight")
        );
        assertEquals(expected, items);
    }

    @Test
    public void itemsAscByName() {
        List<Item> items = Arrays.asList(
                new Item(2, "Two"),
                new Item(6, "Six"),
                new Item(4, "Four")
        );
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item(4, "Four"),
                new Item(6, "Six"),
                new Item(2, "Two")
        );
        assertEquals(items, expected);
    }

    @Test
    public void itemsDescByName() {
        List<Item> items = Arrays.asList(
                new Item(1, "One"),
                new Item(3, "Three"),
                new Item(2, "Two")
        );
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item(2, "Two"),
                new Item(3, "Three"),
                new Item(1, "One")
        );
        assertEquals(items, expected);
    }
}