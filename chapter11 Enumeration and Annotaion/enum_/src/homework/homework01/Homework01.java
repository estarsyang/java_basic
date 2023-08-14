package homework.homework01;

public class Homework01 {
    /*
        1. Create a Color enum
        2. it has RED, BLUE, BLACK three object.
        3. Color has three properties, redValue, greenValue, blueValue
        4. it has constructor to assign properties value
        5. every enum must assign value. red: 255,0,0; blue:0,0,255; black: 0,0,0
        6. Define an interface, it has show method, Color implement the interface.
        7. show method show three properties value
        8. use switch statement to print color.
     */
    public static void main(String[] args) {
        Color red = Color.RED;
        red.show();

        switch (red){
            case RED:
                System.out.println("it's red");
                break;
            case BLUE:
                System.out.println("it's blue");
                break;
            default:
                System.out.println("it's nothing");
        }
    }
}
interface IColor{
    public void show();
}

enum Color implements IColor {
    RED(255,0,0), BLUE(0,0,255),
    BLACK(0,0,0);

    private int redValue;
    private int greenValue;
    private int blueValue;

    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public void show() {
        System.out.println("red:" + this.redValue+" green: "+this.greenValue+" blue:"+this.blueValue);
    }
}
