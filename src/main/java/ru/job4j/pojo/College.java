package ru.job4j.pojo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Иванов Иван Иванович");
        student.setGroup("Первая");
        student.setDate(LocalDate.now());
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        System.out.println("ФИО: " + student.getFio()
                + "\nГруппа: " + student.getGroup()
                + "\nДата зачисления: " + student.getDate().format(dateTimeFormatter));
    }
}
