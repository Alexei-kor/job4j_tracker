package ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class MatrixToListTest {

    @Test
    public void whenConvertMatrixToList() {
        Integer[][] input = {{1, 2, 3, 4}, {8, 7, 6, 5}, {9, 10, 11, 12}};
        List<Integer> expected = List.of(1, 2, 3, 4, 8, 7, 6, 5, 9, 10, 11, 12);
        List<Integer> actual = MatrixToList.convertMatrixToList(input);
        Assert.assertThat(actual, is(expected));
    }
}