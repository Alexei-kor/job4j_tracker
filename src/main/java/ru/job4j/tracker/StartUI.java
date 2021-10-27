package ru.job4j.tracker;

public class StartUI {

    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, UserAction[] userActions) {
        boolean run = true;
        while (run) {
            showMenu(userActions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= userActions.length) {
                out.println("Wrong input, you can select: 0 .. " + (userActions.length - 1));
                continue;
            }
            UserAction userAction = userActions[select];
            run = userAction.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] userActions) {
        out.println("Menu:");
        for (int i = 0; i < userActions.length; i++) {
            out.println(i + ". " + userActions[i].name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput();
        Tracker tracker = new Tracker();
        UserAction[] userActions = {
                new CreateItem(output),
                new ShowAllItem(output),
                new EditItem(output),
                new DeleteItem(output),
                new FindById(output),
                new FindByName(output),
                new Exit()
        };
        new StartUI(output).init(input, tracker, userActions);
    }
}
