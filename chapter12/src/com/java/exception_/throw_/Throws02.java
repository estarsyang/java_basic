package com.java.exception_.throw_;

public class Throws02 {

}

class Father {
    public void m1() throws RuntimeException{}
}

class Son extends Father{
    @Override
    public void m1() throws RuntimeException {

    }
}