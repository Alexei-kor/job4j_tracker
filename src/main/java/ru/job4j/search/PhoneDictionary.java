package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> person = new ArrayList<Person>();

    public void add(Person person) {
        this.person.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> combine = (a) -> a.getName().contains(key);
        Predicate<Person> combine1 = (a) -> a.getSurname().contains(key);
        Predicate<Person> combine2 = (a) -> a.getPhone().contains(key);
        Predicate<Person> combine3 = (a) -> a.getAddress().contains(key);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : person) {
            if (combine.or(combine1.or(combine2.or(combine3))).test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
