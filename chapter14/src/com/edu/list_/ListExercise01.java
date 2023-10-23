package com.edu.list_;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * print all books sort by price.
 */

public class ListExercise01 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Book("vue", 10.2, "evenyou"));
        list.add(new Book("react", 11.2, "anoymous"));
        list.add(new Book("angular", 9.2, "anoymous"));

        sort(list);

        for (Object item : list) {
            System.out.println(item);
        }
    }

    public static void sort(List list) {
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                Book book1 = (Book) list.get(j);
                Book book2 = (Book) list.get(j + 1);
                if (book1.getPrice() > book2.getPrice()) {
                    list.set(j, book2);
                    list.set(j + 1, book1);
                }
            }
        }
    }
}

class Book {
    private String name;
    private Double price;
    private String author;

    public Book(String name, Double price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "name: " + name + "\t\t" +
                "price: " + price + "\t\t" +
                "author:" + author;
    }
}
