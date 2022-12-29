package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.LinkedHashMap;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream
        .flatMap(el -> el.subjects().stream())
                .mapToInt(Subject::score).average().orElse(0);
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .map(el -> new Tuple(el.name(), el.subjects()
                        .stream()
                        .mapToInt(Subject::score)
                        .average()
                        .orElse(0)))
                        .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.flatMap(el -> el.subjects()
                .stream())
                .collect(
                        Collectors.groupingBy(Subject::name,
                                LinkedHashMap::new,
                                Collectors.averagingDouble(Subject::score)))
                .entrySet()
                .stream()
                .map(el -> new Tuple(el.getKey(), el.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(el -> new Tuple(el.name(), el.subjects()
                        .stream()
                        .mapToInt(Subject::score)
                        .sum()))
                        .max(Comparator.comparing(Tuple::score))
                .orElse(new Tuple("we", 0));

    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(el -> el.subjects()
                        .stream())
                .collect(
                        Collectors.groupingBy(Subject::name,
                                LinkedHashMap::new,
                                Collectors.summingDouble(Subject::score)))
                .entrySet()
                .stream()
                .map(el -> new Tuple(el.getKey(), el.getValue()))
                .max(Comparator.comparing(Tuple::score))
                .orElse(new Tuple("we", 0));
    }
}
