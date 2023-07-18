import java.util.Scanner;

public class ArrayTest {
    public static void main(String[] args) {
        MyTools mt = new MyTools();
        int[] arr = {10, -1, 8, 9, 34};
        mt.bubble(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + "\t");
        }

        // keymap
        // 1. delete line -->> command+delete
        int a = 1;
        // 2. duplicate line -->> command+d
        int b = 2;
        int c = 2;
        // 3. code completion -->> control+/  self setting
        MyTools mt1 = new MyTools();
        // 4. comments -->> command+/
        int d = 2;
        // 5. import the class in current line -->> option+enter
        Scanner myScanner = new Scanner(System.in);
        // 6. format code. -->> option+command+l
        int e = 1 + 2 + 4 + 5 * 3;
        // 7. quick run code; -->> control+r
        int f = 123;
        // 10. quick find function. -->> command+b
        mt.bubble(arr);
        // 11. auto assign variables names. the end of line + .var
        Scanner Myscanner1 = new Scanner(System.in);
        Scanner myScanner2 = new Scanner(System.in);

        // 12. close other view. -->> command+w

        // 13. switch code tab -->> control+-> or control+<-

    }
}
// 9. show the Hierarchy of class. -->> control+h
class  Person{
    String name;
    int age;
    // 8. generate constructor -->> option+enter or command+n

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }
}

class MyTools {

    public void bubble(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
