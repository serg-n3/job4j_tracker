package ru.job4j.oop;

public class Error {
    boolean active;
    int status;
    String message;

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public Error() {
    }

    public void printInfo() {
        System.out.println("Наличие ошибки: " + active);
        System.out.println("Код ошибки " + status);
        System.out.println("Описание ощибки: " + message);
    }

    public static void main(String[] args) {
        Error err = new Error();
        err.printInfo();
        Error errOne = new Error(true, 123, "Все переделать!");
        errOne.printInfo();
        Error errTwo = new Error(true, 34, "Удалите пустые строки!");
        errTwo.printInfo();
    }
}
