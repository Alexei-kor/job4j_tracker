package ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.oop.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ProfilesTest {

    @Test
    public void whenGetAdress() {

        List<Address> addresses = List.of(
                new Address("Москва", "Ленинский пр-т", 5, 16),
                new Address("Архангельск", "Минская ", 5, 16),
                new Address("Москва", "Ленинский пр-т", 5, 16),
                new Address("Дмитров", "Новослободская", 5, 16)
                );
        List<Profile> profiles = List.of(new Profile("Иванов", addresses.get(0)),
                new Profile("Петров", addresses.get(1)),
                new Profile("Петров", addresses.get(2)),
                new Profile("Сидоров", addresses.get(3))
        );
        List<Address> actual = Profiles.collect(profiles);
        List<Address> expected = List.of(
                new Address("Архангельск", "Минская ", 5, 16),
                new Address("Дмитров", "Новослободская", 5, 16),
                new Address("Москва", "Ленинский пр-т", 5, 16)
        );
        Assert.assertThat(actual, is(expected));
    }

}