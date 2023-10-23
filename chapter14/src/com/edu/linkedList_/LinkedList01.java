package com.edu.linkedList_;

import java.util.Objects;

public class LinkedList01 {
    public static void main(String[] args) {
        // so simple double linked list.
        Node tom = new Node("tom");
        Node jerry = new Node("jerry");
        Node mary = new Node("mary");

        // to form a linked list
        // tom -> jerry -> mary
        tom.next = jerry;
        jerry.next = mary;

        // mary -> jerry -> tom
        mary.prev = jerry;
        jerry.prev = tom;

        Node first = tom;
        Node last = mary;

        // add a new node 'smith' between 'jerry' and 'mary'
        Node smith = new Node("smith");
        // jerry -> smith -> mary
        jerry.next = smith;
        smith.next = mary;

        smith.prev = jerry;
        mary.prev = smith;

        // iterate linked list
        System.out.println("iterate =========");
        while (true){
            if (first == null){
                break;
            }
            System.out.println(first.item);
            first = first.next;
        }

        // reverse iterate linked list
        System.out.println("reverse iterate =========");
        while (true){
            if (last == null){
                break;
            }
            System.out.println(last.item);
            last = last.prev;
        }

    }
}

class Node {
    public Object item;
    public Node prev;
    public Node next;

    public Node(Object item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Node{" +
                "item=" + item +
                '}';
    }
}
