package ru.job4j.tracker;

public class FindByName implements UserAction {
    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ===");
        String name = input.askStr("Введите наименование заявки: ");
        Item[] found = tracker.findByName(name);
        if (found.length == 0) {
            System.out.println("Заявки с данным именем не найдены");
        } else {
            for (Item item : found) {
                System.out.println(item);
            }
        }
        return true;
    }
}
