class HelloWorld {
    public static void main(String[] args) {
        Phone phone = new Phone();

        Camera camera = new Camera();

        Computer computer = new Computer();

        computer.run(phone);
        computer.run(camera);
    }


}

interface Usb {
    public void start();
}

class Computer {
    public void run(Usb usb) {
        usb.start();
    }
}

class Phone implements Usb {
    public void start(){
        System.out.println("Phone is start...");
    }
}
class Camera implements Usb {
    public void start(){
        System.out.println("Camera is start...");
    }

}