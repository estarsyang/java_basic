package practice.homework06;

public class Homework06 {
    /*
        1. traffic tool interface Vehicles, it has work method.
        2. Horse and Boat class to implement interface Vehicles
        3. Create traffic tool class, it has two methods to get traffic tool Horse and Boat.
        4. Person class, it has name and Vehicle, and assign value in constructor
        5. Create a object of Person class, and usually use Horse as a traffic tool, When pass a river using Boat. Climb
        a mountain by using a plane.
        6. horse is always the horse
     */
    public static void main(String[] args) {
        Horse horse = TrafficToolFactory.getHorse();
        Person tang = new Person("tang", horse);
        tang.normalUse();
        tang.riverUse();
        tang.mountainUse();
    }
}
