package ru.job4j.oop;

public class Cat {

    private String food;
    private String name;

    public String sound() {
        String voice = "may-may";
        return voice;
    }

    public static void main(String[] args) {
        Cat peppy = new Cat();
        String say = peppy.sound();
        System.out.println("Peppy says " + say);
        System.out.println("There are gav's food.");
        Cat gav = new Cat();
        gav.giveNick("gav");
        gav.eat("kotleta");
        gav.show();
        System.out.println("There are black's food.");
        Cat black = new Cat();
        black.giveNick("black");
        black.eat("fish");
        black.show();
    }

    public void show() {
        System.out.println("Cat name is " + this.name + ". Cat ate " + this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

}
