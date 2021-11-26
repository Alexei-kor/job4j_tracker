package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> person = new ArrayList<Person>();

    public void add(Person person) {
        this.person.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> findByName = (a) -> a.getName().contains(key);
        Predicate<Person> findBySurname = (a) -> a.getSurname().contains(key);
        Predicate<Person> findByPhone = (a) -> a.getPhone().contains(key);
        Predicate<Person> findByAddress = (a) -> a.getAddress().contains(key);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : person) {
            if (findByName.or(findBySurname.or(findByPhone.or(findByAddress))).test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
