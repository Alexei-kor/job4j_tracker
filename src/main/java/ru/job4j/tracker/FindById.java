package ru.job4j.tracker;

public class FindById implements UserAction {
    @Override
    public String name() {
        return "Find item by id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find item by id ===");
        int id = input.askInt("Введите идентификатор заявки: ");
        Item found = tracker.findById(id);
        if (found == null) {
            System.out.println("Не удалось найти заявку. "
                    + "Возможно, неверно указан ID заявки.");
        } else {
            System.out.println(found);
        }
        return true;
    }
}
