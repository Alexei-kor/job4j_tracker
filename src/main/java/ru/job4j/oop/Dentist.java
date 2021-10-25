package ru.job4j.oop;

import java.util.Date;

public class Dentist extends Doctor {

    private boolean childlike;

    public Dentist(String name, String surname, String education, Date birthday, String skill, boolean childlike) {
        super(name, surname, education, birthday, skill);
        this.childlike = childlike;
    }

    public void smile() {

    }

}
