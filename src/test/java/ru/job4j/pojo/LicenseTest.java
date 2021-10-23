package ru.job4j.pojo;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class LicenseTest {

    @Test
    public void eqName() {
        License first = new License();
        first.setCode("audio");
        first.setModel("супер");
        License second = new License();
        second.setCode("audio");
        second.setModel("супер");
        assertThat(first, is(second));
    }
}