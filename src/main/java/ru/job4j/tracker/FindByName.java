package ru.job4j.tracker;

public class FindByName implements UserAction {
    private final Output out;

    public FindByName(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find items by name ===");
        String name = input.askStr("Введите наименование заявки: ");
        Item[] found = tracker.findByName(name);
        if (found.length == 0) {
            out.println("Заявки с данным именем не найдены");
        } else {
            for (Item item : found) {
                out.println(item);
            }
        }
        return true;
    }
}
