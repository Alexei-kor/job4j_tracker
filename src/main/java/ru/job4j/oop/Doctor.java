package ru.job4j.oop;

import java.util.Date;

public class Doctor extends Profession {

    private String skill;

    public Doctor(String name, String surname, String education, Date birthday, String skill) {
        super(name, surname, education, birthday);
        this.skill = skill;
    }

    public void heal() {

    }

}
