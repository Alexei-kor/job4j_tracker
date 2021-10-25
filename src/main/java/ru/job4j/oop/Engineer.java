package ru.job4j.oop;

import java.util.Date;

public class Engineer extends Profession {

    private String unit;

    public Engineer(String name, String surname, String education, Date birthday, String unit) {
        super(name, surname, education, birthday);
        this.unit = unit;
    }

    public void completeTask() {

    }

}
