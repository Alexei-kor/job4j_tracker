package ru.job4j.poly;

public class Bus implements Transport {
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
}
