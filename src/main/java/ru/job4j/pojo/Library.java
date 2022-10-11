package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Clean code", 11);
        Book book2 = new Book("Dont touch", 12);
        Book book3 = new Book("My book", 13);
        Book book4 = new Book("Epic", 14);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            System.out.println(bk.getName() + "-" + bk.getCount());
        }
        Book bk1 = new Book(" ", 0);
        bk1 = books[0];
        books[0] = books[3];
        books[3] = bk1;
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            System.out.println(bk.getName() + "-" + bk.getCount());
        }
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            if ("Clean code".equals(bk.getName())) {
                System.out.println(bk.getName() + "-" + bk.getCount());
            }
        }
    }
}
