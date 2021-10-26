package ru.job4j.tracker;

public class DeleteItem implements UserAction {
    private final Output out;

    public DeleteItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Delete item ===");
        int id = input.askInt("Введите идентификатор заявки: ");
        if (tracker.delete(id)) {
            out.println("Заявка успешно удалена");
        } else {
            out.println("Не удалось удалить заявку. "
                    + "Возможно, неверно указан ID заявки.");
        }
        return true;
    }
}
