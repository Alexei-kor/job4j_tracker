package ru.job4j.oop;

import java.util.Date;

public class Builder extends Engineer {

    private boolean superSpec;

    public Builder(String name,
                   String surname,
                   String education,
                   Date birthday,
                   String unit,
                   boolean superSpec) {
        super(name, surname, education, birthday, unit);
        this.superSpec = superSpec;
    }

    public void build() {

    }

}
