package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxTest {

    @Test
    public void when4And5Then5() {
        int one = 4;
        int two = 5;
        int expected = 5;
        int actual = Max.maximum(one, two);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMaximum() {
        int one = 4;
        int two = 5;
        int three = 6;
        int expected = 6;
        int actual = Max.maximum(one, two, three);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMaximum1() {
        int one = 4;
        int two = 5;
        int three = 6;
        int four = 7;
        int expected = 7;
        int actual = Max.maximum(one, two, three, four);
        Assert.assertEquals(expected, actual);
    }
}