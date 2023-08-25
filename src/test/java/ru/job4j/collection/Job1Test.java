package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Job1Test {

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

    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(2);
    }

    @Test
    public void whenCompatorByAscNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(4);
    }

    @Test
    public void whenCompatorByAscNameAndAscPrority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl).isLessThan(4);
    }

}