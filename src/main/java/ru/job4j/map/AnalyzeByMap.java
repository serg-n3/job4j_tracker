package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double sum = 0;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject obj : pupil.subjects()) {
                sum += obj.score();
                count++;
            }
        }
        return sum / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label>  list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0;
            int count = 0;
            for (Subject obj : pupil.subjects()) {
                sum += obj.score();
                count++;
            }
            Label label = new Label(pupil.name(), sum / count);
            list.add(label);
        }
        return list;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label>  list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject obj : pupil.subjects()) {
                map.merge(obj.name(), obj.score(), (k, v) -> map.getOrDefault(obj.name(), 0) + obj.score());
            }
            count++;
        }
        for (String key : map.keySet()) {
            double v = map.get(key);
            Label label = new Label(key, v / count);
            list.add(label);
        }
        return list;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label>  list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0;
            for (Subject obj : pupil.subjects()) {
                sum += obj.score();
            }
            Label label = new Label(pupil.name(), sum);
            list.add(label);
        }
        list.sort(Comparator.naturalOrder());
        return list.get(list.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label>  list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject obj : pupil.subjects()) {
                map.merge(obj.name(), obj.score(), (k, v) -> map.getOrDefault(obj.name(), 0) + obj.score());
            }
        }
        for (String key : map.keySet()) {
            Label label = new Label(key, map.get(key));
            list.add(label);
        }
        list.sort(Comparator.naturalOrder());
        return list.get(list.size() - 1);
    }
}
