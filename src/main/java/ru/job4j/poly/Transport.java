package ru.job4j.poly;

public interface Transport {
    void run();

    void passangers(int count);

    double refuel(double count);
}
