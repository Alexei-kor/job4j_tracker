package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker, UserAction[] userActions) {
        boolean run = true;
        while (run) {
            showMenu(userActions);
            int select = input.askInt("Select: ");
            UserAction userAction = userActions[select];
            run = userAction.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] userActions) {
        System.out.println("Menu:");
        for (int i = 0; i < userActions.length; i++) {
            System.out.println(i + ". " + userActions[i].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] userActions = {
                new CreateItem(),
                new ShowAllItem(),
                new EditItem(),
                new DeleteItem(),
                new FindById(),
                new FindByName(),
                new Exit()
        };
        new StartUI().init(input, tracker, userActions);
    }
}
