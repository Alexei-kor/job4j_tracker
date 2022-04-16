package ru.job4j.tracker;

import java.sql.SQLException;

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
    public boolean execute(Input input, Store tracker) throws SQLException {
        out.println("=== Delete item ===");
        boolean rsl = true;
        do {
            int id = input.askInt("Введите идентификатор заявки: ");
            if (!tracker.delete(id)) {
                out.println("Не удалось удалить заявку. "
                        + "Возможно, неверно указан ID заявки.");
                continue;
            }
            out.println("Заявка успешно удалена");
            rsl = false;
            } while (rsl);
        return true;
    }
}
