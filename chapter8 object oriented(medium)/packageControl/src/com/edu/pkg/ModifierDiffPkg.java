package com.edu.pkg;

import com.edu.modifier.Basic;

//import com.edu.modifier.DefaultClass;  // although import but can't work.

public class ModifierDiffPkg {

    public void diffPkg() {
        // different package only access public properties.
        Basic basic = new Basic();
        System.out.print(basic.m1);

        // different package only access public properties.
//        DefaultClass defaultClass = new DefaultClass(); // error, can't be access in different package.

    }

    public static void main(String[] args) {
        ModifierDiffPkg modifierDiffPkg = new ModifierDiffPkg();
        modifierDiffPkg.diffPkg();
    }
}
