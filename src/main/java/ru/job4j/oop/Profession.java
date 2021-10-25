package ru.job4j.oop;

import java.util.Date;

public class Profession {

    private String name;
    private String surname;
    private String education;
    private Date birthday;

    public Profession(String name, String surname, String education, Date birthday) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }
}
