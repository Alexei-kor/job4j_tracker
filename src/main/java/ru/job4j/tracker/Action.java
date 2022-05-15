package ru.job4j.tracker;

public class Action {

    private static final long KB = 1000;
    private static final long MB = KB * KB;
    private static final Runtime ENVIRONMENT = Runtime.getRuntime();

    public static void info() {
        final long freeMemory = ENVIRONMENT.freeMemory();
        final long totalMemory = ENVIRONMENT.totalMemory();
        final long maxMemory = ENVIRONMENT.maxMemory();
        System.out.println("=== Environment state ===");
        System.out.printf("Free: %d%n", freeMemory / MB);
        System.out.printf("Total: %d%n", totalMemory / MB);
        System.out.printf("Max: %d%n", maxMemory / MB);
    }

    public static void main(String[] args) throws Exception {
        info();
        Output output = new StubOutput();
        String[] answers = new String[1_000_000];
        for (int i = 0; i < answers.length; i++) {
            answers[i] = String.valueOf(i);
        }
        Input input = new StubInput(answers);
        try (MemTracker tracker = new MemTracker()) {
            for (int i = 0; ; i = (i + 1) % answers.length) {
                new CreateItem(output).execute(input, tracker);
                if (i != 0 && i % 10 == 0) {
                    String[] tmp = new String[1];
                    tmp[0] = String.valueOf(i - 1);
                    Input inputDel = new StubInput(tmp);
                    new DeleteItem(output).execute(inputDel, tracker);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            info();
        }

    }
}
