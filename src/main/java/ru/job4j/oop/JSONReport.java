package ru.job4j.oop;

public class JSONReport extends TextReport {
    public String generate(String name, String body) {
        return "{"
                + System.lineSeparator()
                + "\t \"name\" : " + "\"" + name + "\","
                + System.lineSeparator()
                + "\t \"body\" : " + "\"" + body + "\""
                + System.lineSeparator()
                + "}";
    }

    public static void main(String[] args) {
        System.out.println(new JSONReport().generate("name", "body"));
    }

}
