package ru.job4j.oop;

public class Max {

    public static int maximum(int one, int two) {
        return one >= two ? one : two;
    }

    public static int maximum(int one, int two, int three) {
        return maximum(one, maximum(two, three));
    }

    public static int maximum(int one, int two, int three, int four) {
        return maximum(one, maximum(two, maximum(three, four)));
    }

}
