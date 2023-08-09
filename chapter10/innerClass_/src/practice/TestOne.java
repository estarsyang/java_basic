package practice;

public class TestOne {
    public TestOne() {
        Inner s1 = new Inner();
        s1.a = 10;
        Inner s2 = new Inner();
        System.out.println(s2.a);
    }

    class Inner {
        public int a = 5;
    }

    public static void main(String[] args) {
        TestOne testOne = new TestOne(); // 5
        Inner r = testOne.new Inner();
        System.out.println(r.a); // 5
    }
}
