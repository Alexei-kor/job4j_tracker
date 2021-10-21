package ru.job4j.oop;

public class Battery {

    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public void exchange(Battery another) {
        another.load += this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery one = new Battery(10);
        Battery two = new Battery(7);
        System.out.println("One: " + one.load + ", two: " + two.load);
        one.exchange(two);
        System.out.println("One: " + one.load + ", two: " + two.load);
    }

}
