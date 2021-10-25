package ru.job4j.poly;

public class Bus implements Transport, Vehicle {
    @Override
    public void run() {
        System.out.println("Автобус поехал");
    }

    @Override
    public void passangers(int count) {
        System.out.println("Всего " + count + " пассажиров");
    }

    @Override
    public double refuel(double count) {
        return count * 42.51;
    }

    @Override
    public void move() {
        System.out.print("ride");
    }

    @Override
    public int wheels() {
        return 6;
    }
}
