package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void when51And83Then36() {

        Point one = new Point(5, 1);
        Point two = new Point(8, 3);
        double expected = 3.6;
        double actual = one.distance(two);
        Assert.assertEquals(expected, actual, 0.1);

    }
}