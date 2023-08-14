package enum_;

public class Demo01 {
    public static void main(String[] args) {
        Week[] values = Week.values();
        for (Week value: values){
            System.out.println(value);
        }
    }
}

enum Week {
    MONDAY("monday"),
    TUESDAY("tuesday"),
    WEDNESDAY("wednesday");
    //...

    private String name;

    Week(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
