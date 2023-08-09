package bestApply;

public class BestApply01 {
    public static void main(String[] args) {
        show(new AA() {
            @Override
            public void cry() {
                System.out.println("do something");
            }
        });
    }
    public static void show(AA a){
        a.cry();
    }
}

interface AA {
    void cry();
}