package practice.homework06;

public class TrafficToolFactory {
    private static Horse horse = new Horse(); // horse will be always the horse, not change.
    public static Horse getHorse(){
       return horse;
    }

    public static Boat getBoat(){
        return new Boat();
    }

    public static Plane getPlane(){
        return new Plane();
    }
}
