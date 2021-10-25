package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book one = new Book();
        one.setName("CleanCode");
        one.setCountSheets(200);
        Book two = new Book();
        two.setName("BadCode");
        two.setCountSheets(100);
        Book three = new Book();
        three.setName("Test");
        three.setCountSheets(50);
        Book four = new Book();
        four.setName("Test2");
        four.setCountSheets(25);
        Book[] books = new Book[4];
        books[0] = one;
        books[1] = two;
        books[2] = three;
        books[3] = four;
        for (int index = 0; index < books.length; index++) {
            Book currentBook = books[index];
            System.out.println("Name: " + currentBook.getName()
                    + ", count: " + currentBook.getCountSheets());
        }
        books[0] = four;
        books[3] = one;
        for (int index = 0; index < books.length; index++) {
            Book currentBook = books[index];
            System.out.println("Name: " + currentBook.getName()
                    + ", count: " + currentBook.getCountSheets());
        }
        for (int index = 0; index < books.length; index++) {
            Book currentBook = books[index];
            if ("CleanCode".equals(currentBook.getName())) {
                System.out.println("Name: " + currentBook.getName()
                        + ", count: " + currentBook.getCountSheets());
            }
        }
    }
}
