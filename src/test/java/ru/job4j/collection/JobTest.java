package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JobTest {

    @Test
    public void whenComparatorAscByName() {
        List<Job> jobs = Arrays.asList(
                new Job("A", 0),
                new Job("Z", 1),
                new Job("G", 1),
                new Job("B", 1)
        );
        List<Job> expected = Arrays.asList(
                new Job("A", 0),
                new Job("B", 1),
                new Job("G", 1),
                new Job("Z", 1)
        );
        jobs.sort(new JobAscByName());
        assertThat(jobs).isEqualTo(expected);

    }

    @Test
    public void whenComparatorDescByName() {
        List<Job> jobs = Arrays.asList(
                new Job("A", 0),
                new Job("Z", 1),
                new Job("G", 1),
                new Job("B", 1)
        );
        List<Job> expected = Arrays.asList(
                new Job("Z", 1),
                new Job("G", 1),
                new Job("B", 1),
                new Job("A", 0)
        );
        jobs.sort(new JobDescByName());
        assertThat(jobs).isEqualTo(expected);

    }

    @Test
    public void whenComparatorAscByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("A", 5),
                new Job("Z", 13),
                new Job("G", 2),
                new Job("B", 9)
        );
        List<Job> expected = Arrays.asList(
                new Job("G", 2),
                new Job("A", 5),
                new Job("B", 9),
                new Job("Z", 13)
        );
        jobs.sort(new JobAscByPriority());
        assertThat(jobs).isEqualTo(expected);

    }

    @Test
    public void whenComparatorDescByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("A", 5),
                new Job("Z", 13),
                new Job("G", 2),
                new Job("B", 9)
        );
        List<Job> expected = Arrays.asList(
                new Job("Z", 13),
                new Job("B", 9),
                new Job("A", 5),
                new Job("G", 2)
        );
        jobs.sort(new JobDescByPriority());
        assertThat(jobs).isEqualTo(expected);

    }

}