  /**
   * Scanner, a simple text scanner.
   * 1. import package
   * 2. Create Scanner variable, using ```new```.
   * 3. Accept the data by user.
   */
// 1. import package
import java.util.Scanner;

public class Input {

  public static void main(String[] args) {

    // 2. Create Scanner variable, using ```new```.
    Scanner myScanner = new Scanner(System.in);

    // 3. Accept the data by user.
    // nextXX function will wait the input data by user.
     
    System.out.println("Please input your name: ");
    String name = myScanner.next();

    System.out.println("Please input your age: ");
    int age = myScanner.nextInt();

    System.out.println("Please input your salary: ");
    double salary = myScanner.nextDouble();

    System.out.println("Below is your information:");
    System.out.println("name: " + name + ", age: " + age + ", salary: " + salary);
  }
}