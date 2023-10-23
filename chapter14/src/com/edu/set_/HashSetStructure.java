package com.edu.set_;

public class HashSetStructure {
    public static void main(String[] args) {
        Node[] table = new Node[16];
        System.out.println("table=" + table);

        Node john = new Node("john",null);
        table[2] = john;

        Node jack = new Node("jack", null);
        john.next = jack;

        Node rose = new Node("rose", null);
        jack.next = rose;

        table[3] = new Node("lucy",null);
    }
}

class Node {
    Object item;
    Node next;

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }
}
