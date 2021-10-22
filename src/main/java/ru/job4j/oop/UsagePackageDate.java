package ru.job4j.oop;

import com.sun.source.tree.NewArrayTree;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class UsagePackageDate {

    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        System.out.println(currentDate);
        LocalTime currentTime = LocalTime.now();
        System.out.println(currentTime);
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String dateTimeFormat = currentDateTime.format(dateTimeFormatter);
        System.out.println(dateTimeFormat);
    }

}
