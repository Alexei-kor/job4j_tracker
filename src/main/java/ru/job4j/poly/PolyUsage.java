package ru.job4j.poly;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle bus = new Bus();
        Vehicle train = new Train();
        Vehicle[] array = new Vehicle[]{plane, bus, train};
        for (Vehicle vehicle : array) {
            System.out.print(vehicle.getClass().getSimpleName() + " двигается так: ");
            vehicle.move();
            System.out.println(System.lineSeparator()
                    + vehicle.getClass().getSimpleName()
                    + " имеет : "
                    + vehicle.wheels()
                    + " колес");
        }
    }
}
