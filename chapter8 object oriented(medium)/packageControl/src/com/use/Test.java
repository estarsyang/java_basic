package com.use;

import com.tom.Dog;

public class Test {
    public static void main(String[] args) {
        Dog dog = new Dog();
        System.out.println(dog);

        com.bob.Dog dog1 = new com.bob.Dog();
        System.out.println(dog1);
    }
}
