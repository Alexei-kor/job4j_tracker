package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {
        Item item = new Item(1, "Очень важная задача");
        String format = "dd-MMMM-EEEE-yyyy HH:mm:ss";
        DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern(format);
        System.out.println(dtFormatter.format(item.getCreated()));
    }

}
