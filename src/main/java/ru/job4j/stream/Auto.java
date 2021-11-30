package ru.job4j.stream;

import ru.job4j.bank.User;

public class Auto {
    private String model;
    private String color;
    private String id;
    private int year;
    private double power;
    private String owner;
    private String number;

    static class Builder {

        private String model;
        private String color;
        private String id;
        private int year;
        private double power;
        private String owner;
        private String number;

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Builder buildId(String id) {
            this.id = id;
            return this;
        }

        Builder buildYear(int year) {
            this.year = year;
            return this;
        }

        Builder buildPower(double power) {
            this.power = power;
            return this;
        }

        Builder buildOwner(String owner) {
            this.owner = owner;
            return this;
        }

        Builder buildNumber(String number) {
            this.number = number;
            return this;
        }

        Auto build() {
            Auto auto = new Auto();
            auto.model = model;
            auto.color = color;
            auto.id = id;
            auto.year = year;
            auto.power = power;
            auto.owner = owner;
            auto.number = number;
            return auto;
        }
    }

    @Override
    public String toString() {
        return "Auto{"
                + "model='" + model + '\''
                + ", color='" + color + '\''
                + ", id='" + id + '\''
                + ", year=" + year
                + ", power=" + power
                + ", owner='" + owner + '\''
                + ", number='" + number + '\''
                + '}';
    }

    public static void main(String[] args) {
        Auto auto = new Builder()
                .buildModel("Mersedes")
                .buildColor("black")
                .buildId("AAA345677BBB")
                .buildYear(2021)
                .buildPower(199.5d)
                .buildOwner("Ivanov")
                .buildNumber("a777aa77")
                .build();
        System.out.println(auto);
    }
}
