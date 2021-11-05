package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> person = new ArrayList<Person>();

    public void add(Person person) {
        this.person.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person el: person) {
            if (el.getName().contains(key)
                    || el.getSurname().contains(key)
                    || el.getAddress().contains(key)
                    || el.getPhone().contains(key)) {
                result.add(el);
            }
        }
        return result;
    }
}
