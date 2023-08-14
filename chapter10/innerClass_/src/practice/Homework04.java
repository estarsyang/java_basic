package practice;

public class Homework04 {
    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
        cellPhone.testWork(new ICalcualte() {
            @Override
            public double work(double n1, double n2) {
                return n1+n2;
            }
        },10,8);
    }
}


interface ICalcualte {
    public double work(double n1, double n2);
}

class CellPhone {
    public void testWork(ICalcualte iCalcualte, double n1, double n2) {
        double result = iCalcualte.work(n1,n2);
        System.out.println(result);
    }
}