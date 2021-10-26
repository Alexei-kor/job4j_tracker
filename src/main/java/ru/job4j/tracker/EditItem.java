package ru.job4j.tracker;

public class EditItem implements UserAction {
    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Edit item ===");
        int id = input.askInt("Введите идентификатор заявки: ");
        String newName = input.askStr("Введите новое наименование заявки: ");
        Item item = new Item(newName);
        if (tracker.replace(id, item)) {
            System.out.println("Замена выполнена успешно");
        } else {
            System.out.println("Не удалось выполнить замену. "
                    + "Возможно, неверно указан ID заявки для замены");
        }
        return true;
    }
}
