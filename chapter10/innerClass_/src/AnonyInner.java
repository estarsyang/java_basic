public class AnonyInner {
    public static void main(String[] args) {
        Outer01 outer01 = new Outer01();
        outer01.action();
    }
}

interface IA {
    public void cry();
}

class Outer01 {

    public void action() {
        IA tiger = new IA(){
            @Override
            public void cry() {
                System.out.println("tiger is crying...");
            }
        };
        tiger.cry();

        // anonymous class for class.
        Father jack = new Father("jack"){
            @Override
            public void say() {
                super.say();
            }
        };

        System.out.println(jack.getClass());

        Animal animal = new Animal() {
            @Override
            void eat() {
                System.out.println("animal is eating");
            }
        };
        animal.eat();
    }
}

class Father {
    public Father(String name) {
        System.out.println(name);
    }

    public void say(){
        System.out.println("father is saying...");
    }
}
abstract class Animal {
    abstract void eat();
}