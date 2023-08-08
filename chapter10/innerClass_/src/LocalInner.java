public class LocalInner {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.m1();
    }
}

class Outer {
    private int n1 = 100;

    public void m1() {
        final class Inner {
            private int n1 = 200;

            public void f1() {
                // 2. Could access outer class's all members, including private
                // 5. Local inner class can directly access outer class members
                System.out.println(n1);

                System.out.println("outer class member " + Outer.this.n1);
                System.out.println("outer class member none outerClass " + this.n1);
                m2();
            }
        }
        // 6. Outer class could create inner class object in methods, and call inner class's method
        Inner inner = new Inner();
        inner.f1();
    }

    public void m2() {
        System.out.println("outer m2");
    }
}