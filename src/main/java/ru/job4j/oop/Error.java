package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Описание: " + message + " / Активность: " + active + " / Статус: " + status);
    }

    public static void main(String[] args) {
        Error error = new Error();
        error.printInfo();
        Error error1 = new Error(true, 1, "Ошибка при запуске приложения");
        error1.printInfo();
        Error error2 = new Error(true, 2, "Ошибка при вызове команды 1");
        error2.printInfo();
    }
}
