package ru.job4j.tracker;

import java.sql.SQLException;

public class EditItem implements UserAction {

    private final Output out;

    public EditItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Store tracker) throws SQLException {
        out.println("=== Edit item ===");
        int id = input.askInt("Введите идентификатор заявки: ");
        String newName = input.askStr("Введите новое наименование заявки: ");
        Item item = new Item(newName);
        if (tracker.replace(id, item)) {
            out.println("Замена выполнена успешно");
        } else {
            out.println("Не удалось выполнить замену. "
                    + "Возможно, неверно указан ID заявки для замены");
        }
        return true;
    }
}
