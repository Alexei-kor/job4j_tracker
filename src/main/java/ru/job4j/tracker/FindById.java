package ru.job4j.tracker;

public class FindById implements UserAction {
    private final Output out;

    public FindById(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by id";
    }

    @Override
    public boolean execute(Input input, TaskTracker tracker) {
        out.println("=== Find item by id ===");
        int id = input.askInt("Введите идентификатор заявки: ");
        Item found = tracker.findById(id);
        if (found == null) {
            out.println("Не удалось найти заявку. "
                    + "Возможно, неверно указан ID заявки.");
        } else {
            out.println(found);
        }
        return true;
    }
}
