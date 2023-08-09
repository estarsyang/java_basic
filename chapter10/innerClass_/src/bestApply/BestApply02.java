package bestApply;

public class BestApply02 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("u are No.1");
            }
        });

        phone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("u are the best");
            }
        });
    }
}
interface Bell {
    void ring();
}
class Phone {
    public void alarmClock(Bell bell){
        bell.ring();
    }
}