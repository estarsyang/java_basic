package practice.homework07;

public class Homework07 {
    /*
        There is a Car class, it has temperature, and it has an inner class, Air class. There is flow method
        in Air class, Air observe temperature. If temperature is higher than 40 degree, it will be sent cold air.
        if temperature is lower than 0 degree, it will be sent warm air. if temperature is between 0 and 40, close
        the air conditioner. Instance of different temperature Car object, call flow method, test air is right or not
     */
    public static void main(String[] args) {

        Car car1 = new Car(50);
        car1.getAir().flow();

        Car car2 = new Car(-1);
        car2.getAir().flow();

        Car car3 = new Car(10);
        car3.getAir().flow();
    }
}

class Car {
    private double temperature;

    public Car(double temperature) {
        this.temperature = temperature;
    }

    class Air {
        public void flow(){
            if (temperature > 40) {
                System.out.println("cold air");
            } else if (temperature < 0){
                System.out.println("warm air");
            } else {
                System.out.println("close air conditioner");
            }
        }
    }

    public Air getAir() {
        return new Air();
    }
}