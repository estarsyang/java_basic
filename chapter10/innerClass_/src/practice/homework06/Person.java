package practice.homework06;

public class Person {
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.setName(name);
        this.setVehicles(vehicles);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicles getVehicles() {
        return vehicles;
    }

    public void setVehicles(Vehicles vehicles) {
        this.vehicles = vehicles;
    }

    public void normalUse() {
        if (!(vehicles instanceof Horse)) {
            vehicles = TrafficToolFactory.getHorse();
        }
        vehicles.work();
    }

    public void riverUse(){
        if (!(vehicles instanceof Boat)) {
            vehicles = TrafficToolFactory.getBoat();
        }
        vehicles.work();
    }

    public void mountainUse(){
        if (!(vehicles instanceof Plane)) {
            vehicles = TrafficToolFactory.getPlane();
        }
        vehicles.work();
    }
}
