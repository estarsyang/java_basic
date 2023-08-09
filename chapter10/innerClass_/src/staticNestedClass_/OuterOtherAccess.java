package staticNestedClass_;

public class OuterOtherAccess {
    public static void main(String[] args) {
        Outer.Inner innerInstance = new Outer().getInnerInstance();

        // or
        Outer.Inner innerInstance_ = Outer.getInnerInstance_();


    }
}

class Outer {


    static class  Inner {

    }

    public Inner getInnerInstance() {
        return new Inner();
    }

    public static Inner getInnerInstance_() {
        return new Inner();
    }
}
