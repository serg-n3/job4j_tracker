package ru.job4j.queue;

import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Queue<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Queue<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder str = new StringBuilder();
        int s = evenElements.size();
        for (int i = 0; i < s; i++) {
            if (i % 2 == 0) {
                str.append(evenElements.remove());
            } else {
                evenElements.remove();
            }
        }
        return str.toString();
    }

    private String getDescendingElements() {
        Iterator<Character> iterator = descendingElements.descendingIterator();
        StringBuilder str = new StringBuilder();
        while (iterator.hasNext()) {
            str.append(iterator.next());
        }
        return str.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
