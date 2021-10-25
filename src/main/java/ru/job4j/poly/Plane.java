package ru.job4j.poly;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.print("fly");
    }

    @Override
    public int wheels() {
        return 10;
    }
}
