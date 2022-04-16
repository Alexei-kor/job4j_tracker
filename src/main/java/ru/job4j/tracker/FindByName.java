package ru.job4j.tracker;

import java.sql.SQLException;
import java.util.List;

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
    public boolean execute(Input input, Store tracker) throws SQLException {
        out.println("=== Find items by name ===");
        String name = input.askStr("Введите наименование заявки: ");
        List<Item> found = tracker.findByName(name);
        if (found.size() == 0) {
            out.println("Заявки с данным именем не найдены");
        } else {
            for (Item item : found) {
                out.println(item);
            }
        }
        return true;
    }
}
