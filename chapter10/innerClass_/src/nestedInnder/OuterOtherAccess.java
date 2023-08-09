package nestedInnder;

public class OuterOtherAccess {
    public static void main(String[] args) {
        Outer.Inner innerInstance = new Outer().getInnerInstance();

    }
}

class Outer {


    class Inner {

    }

    public Inner getInnerInstance() {
        return new Inner();
    }
}
