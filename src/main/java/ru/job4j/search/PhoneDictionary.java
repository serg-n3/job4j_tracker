package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> comb1 = person -> person.getName().contains(key);
        Predicate<Person> comb2 = person -> person.getSurname().contains(key);
        Predicate<Person> comb3 = person -> person.getPhone().contains(key);
        Predicate<Person> comb4 = person -> person.getAddress().contains(key);
        Predicate<Person> combine = comb1.or(comb2).or(comb3).or(comb4);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
