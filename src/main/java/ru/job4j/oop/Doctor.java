package ru.job4j.oop;

public class Doctor extends Profession {

    private String skill;
    private int numberClinic;

    public Doctor() {
    }

    public Doctor(String skill, int numberClinic) {
        this.skill = skill;
        this.numberClinic = numberClinic;
    }

    public void heal() {

    }

}
