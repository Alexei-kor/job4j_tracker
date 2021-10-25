package ru.job4j.oop;

import java.util.Date;

public class Surgeon extends Doctor {

    private byte age;

    public Surgeon(String name,
                   String surname,
                   String education,
                   Date birthday,
                   String skill,
                   byte age) {
        super(name, surname, education, birthday, skill);
        this.age = age;
    }

    public void replaceRobe() {

    }

}
