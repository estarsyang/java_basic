package com.edu.poly_.dynamic_;

public class DynamicBinding {

    public static void main(String[] args) {
        Father p1 = new Son();
        System.out.println(p1.sum());
        System.out.println(p1.sum1());
    }
}


class Father {
    int i = 10;

    public int getI() {
        return i;
    }

    public int sum() {
        return getI() + 10;
    }

    public int sum1() {
        return i + 10;
    }
}

class Son extends Father {
    int i = 20;

    public int getI() {
        return i;
    }

//    public int sum() {
//        return getI() + 10;
//    }
//
//    public int sum1() {
//        return i + 10;
//    }
}