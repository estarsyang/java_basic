package generic.exercise02;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Employee class
 * 1. properties: name,sal, birthday, birthday is  MyDate object.
 * 2. defined getter and setter for each property
 * 3. rewrite toString to print name, sal, birthday
 * 4. MyDate class has: month, day, year, defined getter and setter for each one
 * 5. create three Employee objects and store in Arraylist and sort.
 * 6. sort rules: sort by name, if name is equal, using birthday.
 */


public class GenericExercise02 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee("tom", 100, new MyDate(1991, 10, 10)));
        employees.add(new Employee("jack", 200, new MyDate(1991, 10, 10)));
        employees.add(new Employee("tom", 300, new MyDate(1991, 10, 12)));

        System.out.println(employees);

        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
                if (!(emp1 instanceof Employee && emp2 instanceof Employee)) {
                    System.out.println("type is error");
                    return 0;
                }
//                compare name
                int i = emp1.getName().compareTo(emp2.getName());

                if (i != 0) {
                    return i;
                }
//                compare birthday
                return emp1.getBirthday().compareTo(emp2.getBirthday());

            }
        });

        System.out.println(employees);
    }
}
