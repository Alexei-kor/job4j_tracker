package ru.job4j.tracker;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StartUI {

    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store tracker, List<UserAction> userActions) throws SQLException {
        boolean run = true;
        while (run) {
            showMenu(userActions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= userActions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (userActions.size() - 1));
                continue;
            }
            UserAction userAction = userActions.get(select);
            run = userAction.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> userActions) {
        out.println("Menu:");
        for (int i = 0; i < userActions.size(); i++) {
            out.println(i + ". " + userActions.get(i).name());
        }
    }

    public static void main(String[] args) throws Exception {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        try (SqlTracker tracker = new SqlTracker()) {
            tracker.init();
            List<UserAction> userActions = new ArrayList<UserAction>();
            userActions.add(new CreateItem(output));
            userActions.add(new ShowAllItem(output));
            userActions.add(new EditItem(output));
            userActions.add(new DeleteItem(output));
            userActions.add(new FindById(output));
            userActions.add(new FindByName(output));
            userActions.add(new Exit());
            new StartUI(output).init(input, tracker, userActions);
        }
    }
}
