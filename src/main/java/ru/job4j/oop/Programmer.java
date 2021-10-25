package ru.job4j.oop;

import java.util.Date;

public class Programmer extends Engineer {

    private String language;

    public Programmer(String name,
                      String surname,
                      String education,
                      Date birthday,
                      String unit,
                      String language) {
        super(name, surname, education, birthday, unit);
        this.language = language;
    }

    public void drinkBeer() {

    }

}
