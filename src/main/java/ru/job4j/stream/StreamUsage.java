package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {

    public static class Task {
        private final String name;
        private final long spent;

        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0, 1, -2, 3, -4, 5, -6, 7);
        List<Integer> listNew = list.stream().filter(el -> el > 0).collect(Collectors.toList());
        System.out.println(listNew);
        List<Task> tasks = List.of(
                new Task("Bug #1", 10),
                new Task("Task #2", 20),
                new Task("Bug", 40)
        );
        tasks.stream()
                .filter(task -> task.name.equals("Bug"))
                .filter(task -> task.spent > 30)
                .map(task -> task.name + " " + task.spent)
                .forEach(System.out::println);
    }
}

