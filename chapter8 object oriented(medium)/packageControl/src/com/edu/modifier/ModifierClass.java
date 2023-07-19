package com.edu.modifier;
// only public and default can be modified class.
public class ModifierClass {
    public static void main(String[] args) {
        // default modifies class -->> same class same package
        DefaultClass defaultClass = new DefaultClass();

    }
}

class DefaultClass{}
